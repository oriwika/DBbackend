-- 图书管理系统索引优化脚本
-- 建议在生产环境部署前执行此脚本

-- ========================================
-- 1. 图书表 (tb_book) 索引
-- ========================================

-- 书名查询索引（支持模糊查询）
CREATE INDEX idx_book_title ON tb_book(title);

-- 作者查询索引（支持模糊查询）
CREATE INDEX idx_book_author ON tb_book(author);

-- 分类查询索引（精确匹配，高频使用）
CREATE INDEX idx_book_category ON tb_book(category_id);

-- 出版社查询索引（精确匹配，高频使用）
CREATE INDEX idx_book_publisher ON tb_book(publisher_id);

-- 库存预警查询索引（用于统计和预警）
CREATE INDEX idx_book_stock ON tb_book(total_stock);

-- 复合索引：分类+库存（用于分类库存统计）
CREATE INDEX idx_book_category_stock ON tb_book(category_id, total_stock);

-- ========================================
-- 2. 订单相关表索引
-- ========================================

-- 销售订单日期索引（用于日期范围查询和统计）
CREATE INDEX idx_sales_order_date ON tb_sales_order(order_date);

-- 进货订单日期索引（用于日期范围查询和统计）
CREATE INDEX idx_purchase_order_date ON tb_purchase_order(order_date);

-- 销售明细外键索引（提升JOIN性能）
CREATE INDEX idx_sales_detail_order ON tb_sales_detail(order_id);
CREATE INDEX idx_sales_detail_book ON tb_sales_detail(book_id);
CREATE INDEX idx_sales_detail_warehouse ON tb_sales_detail(warehouse_id);

-- 进货明细外键索引（提升JOIN性能）
CREATE INDEX idx_purchase_detail_order ON tb_purchase_detail(order_id);
CREATE INDEX idx_purchase_detail_book ON tb_purchase_detail(book_id);
CREATE INDEX idx_purchase_detail_warehouse ON tb_purchase_detail(warehouse_id);

-- 复合索引：图书+订单日期（用于热销统计）
CREATE INDEX idx_sales_book_date ON tb_sales_detail(book_id, order_id);

-- ========================================
-- 3. 库存表 (tb_inventory) 索引
-- ========================================

-- 仓库+图书复合索引（用于库存查询和更新，最重要的索引）
CREATE INDEX idx_inventory_warehouse_book ON tb_inventory(warehouse_id, book_id);

-- 图书库存查询索引（用于跨仓库库存统计）
CREATE INDEX idx_inventory_book ON tb_inventory(book_id);

-- 仓库库存查询索引（用于仓库管理）
CREATE INDEX idx_inventory_warehouse ON tb_inventory(warehouse_id);

-- ========================================
-- 4. 分类和出版社表索引
-- ========================================

-- 分类名称查询索引（支持模糊查询）
CREATE INDEX idx_category_name ON tb_book_category(category_name);

-- 出版社名称查询索引（支持模糊查询）
CREATE INDEX idx_publisher_name ON tb_publisher(publisher_name);

-- ========================================
-- 5. 仓库表索引
-- ========================================

-- 仓库名称查询索引（支持模糊查询）
CREATE INDEX idx_warehouse_name ON tb_warehouse(warehouse_name);

-- ========================================
-- 索引使用说明
-- ========================================

/*
性能优化重点：
1. 高频查询优化：图书分类、出版社查询
2. 日期范围查询：订单统计、报表生成
3. 库存管理：仓库+图书复合查询
4. 模糊搜索：书名、作者搜索
5. 外键关联：订单明细表JOIN操作

索引优先级：
【高优先级】
- idx_book_category（图书分类查询）
- idx_book_publisher（出版社查询）
- idx_inventory_warehouse_book（库存管理核心索引）
- idx_sales_order_date（销售统计）
- idx_purchase_order_date（进货统计）

【中优先级】
- idx_book_title（书名搜索）
- idx_book_author（作者搜索）
- idx_book_stock（库存预警）
- 明细表外键索引

【低优先级】
- 名称模糊查询索引
- 复合统计索引

注意事项：
1. 索引会占用额外存储空间（约10-15%）
2. 会略微降低INSERT/UPDATE/DELETE性能（约5-10%）
3. 对于读多写少的图书管理系统，收益远大于成本
4. 建议在业务低峰期创建索引
5. 定期使用ANALYZE TABLE优化索引统计信息
*/