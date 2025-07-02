-- 存储过程：查询某段时间内各种图书的进货和销售情况
DELIMITER //
CREATE PROCEDURE sp_GetBookInventoryStats(
    IN start_date DATETIME,
    IN end_date DATETIME
)
BEGIN
    SELECT 
        b.book_id,
        b.title,
        b.author,
        COALESCE(SUM(pd.quantity), 0) AS total_purchased,
        COALESCE(SUM(sd.quantity), 0) AS total_sold
    FROM tb_book b
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
END //
DELIMITER ;

DROP PROCEDURE sp_GetBookInventoryStats;
-- 存储过程：查询某段时间内各种图书的进货和销售情况（分页版本)
DELIMITER //
CREATE PROCEDURE sp_GetBookInventoryStats(
    IN start_date DATETIME,
    IN end_date DATETIME
)
BEGIN
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
END //
DELIMITER ;

CALL sp_GetBookInventoryStats('2025-06-30', '2025-7-1');

-- 视图：查询各类图书的库存总数
CREATE VIEW vw_CategoryInventory AS
SELECT 
    c.category_id,
    c.category_name,
    COALESCE(SUM(i.quantity), 0) AS total_inventory
FROM tb_book_category c
LEFT JOIN tb_book b ON c.category_id = b.category_id
LEFT JOIN tb_inventory i ON b.book_id = i.book_id
GROUP BY c.category_id, c.category_name;

SELECT * FROM vw_CategoryInventory;


DROP TRIGGER IF EXISTS trg_AfterInsertPurchaseDetail;
DROP TRIGGER IF EXISTS trg_AfterInsertSalesDetail;


-- 触发器：图书入库时自动修改库存
DELIMITER //
CREATE TRIGGER trg_AfterInsertPurchaseDetail
AFTER INSERT ON tb_purchase_detail
FOR EACH ROW
BEGIN
    -- 更新图书总库存
    UPDATE tb_book
    SET total_stock = total_stock + NEW.quantity
    WHERE book_id = NEW.book_id;
    
    -- 更新仓库中的图书数量（明细中已包含仓库ID）
    INSERT INTO tb_inventory (book_id, warehouse_id, quantity)
    VALUES (NEW.book_id, NEW.warehouse_id, NEW.quantity)
    ON DUPLICATE KEY UPDATE 
        quantity = quantity + NEW.quantity;
END //
DELIMITER ;

-- 出库
DELIMITER //
CREATE TRIGGER trg_AfterInsertSalesDetail
AFTER INSERT ON tb_sales_detail
FOR EACH ROW
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
END //
DELIMITER ;


/*
DROP TRIGGER IF EXISTS trg_UpdateInventoryOnPurchase;
-- 仓库库存更新触发器（采购）
DELIMITER //
CREATE TRIGGER trg_UpdateInventoryOnPurchase
AFTER INSERT ON tb_purchase_detail
FOR EACH ROW
BEGIN
    DECLARE warehouse_id_val INT;
    
    -- 获取关联的仓库ID
    SELECT warehouse_id INTO warehouse_id_val 
    FROM tb_purchase_order 
    WHERE order_id = NEW.order_id;
    
    -- 仅更新仓库库存（不含总库存）
    INSERT INTO tb_inventory (book_id, warehouse_id, quantity)
    VALUES (NEW.book_id, warehouse_id_val, NEW.quantity)
    ON DUPLICATE KEY UPDATE 
        quantity = quantity + NEW.quantity;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS trg_UpdateTotalStockOnPurchase;
-- 总库存更新触发器（采购）
DELIMITER //
CREATE TRIGGER trg_UpdateTotalStockOnPurchase
AFTER INSERT ON tb_purchase_detail
FOR EACH ROW
BEGIN
    -- 在另一个语句之后更新总库存
    UPDATE tb_book
    SET total_stock = total_stock + NEW.quantity
    WHERE book_id = NEW.book_id;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS trg_UpdateInventoryOnSale;
-- 仓库库存更新触发器（销售）
DELIMITER //
CREATE TRIGGER trg_UpdateInventoryOnSale
AFTER INSERT ON tb_sales_detail
FOR EACH ROW
BEGIN
    DECLARE warehouse_id_val INT;
    
    -- 获取关联的仓库ID
    SELECT warehouse_id INTO warehouse_id_val 
    FROM tb_sales_order 
    WHERE order_id = NEW.order_id;
    
    -- 仅更新仓库库存
    UPDATE tb_inventory 
    SET quantity = quantity - NEW.quantity 
    WHERE book_id = NEW.book_id 
    AND warehouse_id = warehouse_id_val;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS trg_UpdateTotalStockOnSale;
-- 总库存更新触发器（销售）
DELIMITER //
CREATE TRIGGER trg_UpdateTotalStockOnSale
AFTER INSERT ON tb_sales_detail
FOR EACH ROW
BEGIN
    -- 在另一个语句之后更新总库存
    UPDATE tb_book
    SET total_stock = total_stock - NEW.quantity
    WHERE book_id = NEW.book_id;
END //
DELIMITER ;
*>