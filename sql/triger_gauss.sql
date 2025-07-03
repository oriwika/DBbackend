-- ----------------------------
-- OpenGauss兼容版本 - 存储过程、视图和触发器
-- ----------------------------

-- 存储过程：查询某段时间内各种图书的进货和销售情况
CREATE OR REPLACE FUNCTION sp_GetBookInventoryStats(
    start_date timestamp,
    end_date timestamp
)
RETURNS TABLE(
    book_id integer,
    title varchar(200),
    author varchar(100),
    total_purchased bigint,
    total_sold bigint
)
AS $$
BEGIN
    RETURN QUERY
    SELECT 
        b.book_id,
        b.title,
        b.author,
        COALESCE(SUM(pd.quantity), 0) AS total_purchased,
        COALESCE(SUM(sd.quantity), 0) AS total_sold
    FROM (
        -- 获取有进货或销售记录的图书ID
        SELECT DISTINCT book_id
        FROM (
            SELECT pd.book_id
            FROM tb_purchase_detail pd
            JOIN tb_purchase_order po ON pd.order_id = po.order_id
            WHERE po.order_date BETWEEN start_date AND end_date
            
            UNION
            
            SELECT sd.book_id
            FROM tb_sales_detail sd
            JOIN tb_sales_order so ON sd.order_id = so.order_id
            WHERE so.order_date BETWEEN start_date AND end_date
        ) AS active_books
    ) AS ab
    JOIN tb_book b ON ab.book_id = b.book_id
    LEFT JOIN (
        SELECT pd.book_id, pd.quantity
        FROM tb_purchase_detail pd
        JOIN tb_purchase_order po ON pd.order_id = po.order_id
        WHERE po.order_date BETWEEN start_date AND end_date
    ) pd ON b.book_id = pd.book_id
    LEFT JOIN (
        SELECT sd.book_id, sd.quantity
        FROM tb_sales_detail sd
        JOIN tb_sales_order so ON sd.order_id = so.order_id
        WHERE so.order_date BETWEEN start_date AND end_date
    ) sd ON b.book_id = sd.book_id
    GROUP BY b.book_id, b.title, b.author;
END;
$$ LANGUAGE plpgsql;

-- 调用示例：
-- SELECT * FROM sp_GetBookInventoryStats('2025-06-30'::timestamp, '2025-07-01'::timestamp);

-- 视图：查询各类图书的库存总数
CREATE OR REPLACE VIEW vw_CategoryInventory AS
SELECT 
    c.category_id,
    c.category_name,
    COALESCE(SUM(i.quantity), 0) AS total_inventory
FROM tb_book_category c
LEFT JOIN tb_book b ON c.category_id = b.category_id
LEFT JOIN tb_inventory i ON b.book_id = i.book_id
GROUP BY c.category_id, c.category_name;

-- 查询视图示例：
-- SELECT * FROM vw_CategoryInventory;

-- 删除已存在的触发器
DROP TRIGGER IF EXISTS trg_AfterInsertPurchaseDetail ON tb_purchase_detail;
DROP TRIGGER IF EXISTS trg_AfterInsertSalesDetail ON tb_sales_detail;

-- 触发器函数：图书入库时自动修改库存
CREATE OR REPLACE FUNCTION fn_after_insert_purchase_detail()
RETURNS TRIGGER AS $$
BEGIN
    -- 更新图书总库存
    UPDATE tb_book
    SET total_stock = total_stock + NEW.quantity
    WHERE book_id = NEW.book_id;
    
    -- 更新仓库中的图书数量（明细中已包含仓库ID）
    INSERT INTO tb_inventory (book_id, warehouse_id, quantity)
    VALUES (NEW.book_id, NEW.warehouse_id, NEW.quantity)
    ON CONFLICT (book_id, warehouse_id) DO UPDATE SET
        quantity = tb_inventory.quantity + NEW.quantity;
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- 创建进货触发器
CREATE TRIGGER trg_AfterInsertPurchaseDetail
    AFTER INSERT ON tb_purchase_detail
    FOR EACH ROW
    EXECUTE FUNCTION fn_after_insert_purchase_detail();

-- 触发器函数：图书出库时自动修改库存
CREATE OR REPLACE FUNCTION fn_after_insert_sales_detail()
RETURNS TRIGGER AS $$
BEGIN
    -- 更新图书总库存
    UPDATE tb_book
    SET total_stock = total_stock - NEW.quantity
    WHERE book_id = NEW.book_id;
    
    -- 更新仓库中的图书数量（直接使用明细中的仓库ID）
    UPDATE tb_inventory 
    SET quantity = quantity - NEW.quantity 
    WHERE book_id = NEW.book_id 
      AND warehouse_id = NEW.warehouse_id;
    
    -- 如果库存清零，删除该条记录
    DELETE FROM tb_inventory 
    WHERE book_id = NEW.book_id 
      AND warehouse_id = NEW.warehouse_id 
      AND quantity = 0;
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- 创建销售触发器
CREATE TRIGGER trg_AfterInsertSalesDetail
    AFTER INSERT ON tb_sales_detail
    FOR EACH ROW
    EXECUTE FUNCTION fn_after_insert_sales_detail();

-- 主要修改内容：
-- 1. DELIMITER语法 -> 使用$$分隔符
-- 2. MySQL存储过程语法 -> PostgreSQL函数语法
-- 3. BEGIN...END -> $$ LANGUAGE plpgsql
-- 4. ON DUPLICATE KEY UPDATE -> ON CONFLICT...DO UPDATE
-- 5. 触发器需要先创建函数，再创建触发器
-- 6. DATETIME -> timestamp
-- 7. INT -> integer
-- 8. DECLARE变量语法调整