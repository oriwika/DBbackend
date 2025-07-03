-- ----------------------------
-- OpenGauss兼容版本 - 书店业务表
-- ----------------------------

-- 1. 图书分类表
CREATE TABLE tb_book_category (
   category_id integer not null,
   category_name VARCHAR(50) NOT NULL UNIQUE,
   description TEXT,
   primary key (category_id)
);

-- 创建序列
create sequence tb_book_category_seq start with 1;
alter table tb_book_category alter column category_id set default nextval('tb_book_category_seq');

-- 2. 出版社表
CREATE TABLE tb_publisher (
   publisher_id integer not null,
   publisher_name VARCHAR(100) NOT NULL UNIQUE,
   contact_phone VARCHAR(20),
   address TEXT,
   primary key (publisher_id)
);

-- 创建序列
create sequence tb_publisher_seq start with 1;
alter table tb_publisher alter column publisher_id set default nextval('tb_publisher_seq');

-- 3. 图书表
CREATE TABLE tb_book (
    book_id integer not null,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    category_id integer NOT NULL,
    publisher_id integer NOT NULL,
    purchase_price DECIMAL(10,2), -- 进货价
    retail_price DECIMAL(10,2), -- 零售价
    total_stock integer DEFAULT 0, -- 总库存
    primary key (book_id),
    FOREIGN KEY (category_id) REFERENCES tb_book_category(category_id),
    FOREIGN KEY (publisher_id) REFERENCES tb_publisher(publisher_id)
);

-- 创建序列
create sequence tb_book_seq start with 1;
alter table tb_book alter column book_id set default nextval('tb_book_seq');

-- 4. 仓库表
CREATE TABLE tb_warehouse (
    warehouse_id integer not null,
    warehouse_name VARCHAR(50) NOT NULL UNIQUE,
    location VARCHAR(200),
    manager VARCHAR(50),
    primary key (warehouse_id)
);

-- 创建序列
create sequence tb_warehouse_seq start with 1;
alter table tb_warehouse alter column warehouse_id set default nextval('tb_warehouse_seq');

-- 5. 库存表
CREATE TABLE tb_inventory (
    book_id integer NOT NULL,
    warehouse_id integer NOT NULL,
    quantity integer DEFAULT 0 CHECK (quantity >= 0),
    PRIMARY KEY (book_id, warehouse_id),
    FOREIGN KEY (book_id) REFERENCES tb_book(book_id),
    FOREIGN KEY (warehouse_id) REFERENCES tb_warehouse(warehouse_id)
);

-- 6. 进货单主表
CREATE TABLE tb_purchase_order (
   order_id integer not null,
   order_date timestamp DEFAULT CURRENT_TIMESTAMP,
   primary key (order_id)
);

-- 创建序列
create sequence tb_purchase_order_seq start with 1;
alter table tb_purchase_order alter column order_id set default nextval('tb_purchase_order_seq');

-- 7. 进货明细表（支持多本书）
CREATE TABLE tb_purchase_detail (
    detail_id integer not null,
    order_id integer NOT NULL,
    warehouse_id integer NOT NULL,  -- 仓库字段
    book_id integer NOT NULL,
    quantity integer NOT NULL CHECK (quantity > 0),
    primary key (detail_id),
    FOREIGN KEY (order_id) REFERENCES tb_purchase_order(order_id),
    FOREIGN KEY (warehouse_id) REFERENCES tb_warehouse(warehouse_id),
    FOREIGN KEY (book_id) REFERENCES tb_book(book_id)
);

-- 创建序列
create sequence tb_purchase_detail_seq start with 1;
alter table tb_purchase_detail alter column detail_id set default nextval('tb_purchase_detail_seq');

-- 8. 销售单主表
CREATE TABLE tb_sales_order (
    order_id integer not null,
    order_date timestamp DEFAULT CURRENT_TIMESTAMP,
    primary key (order_id)
);

-- 创建序列
create sequence tb_sales_order_seq start with 1;
alter table tb_sales_order alter column order_id set default nextval('tb_sales_order_seq');

-- 9. 销售明细表（支持多本书）
CREATE TABLE tb_sales_detail (
    detail_id integer not null,
    order_id integer NOT NULL,
    warehouse_id integer NOT NULL,  -- 仓库字段
    book_id integer NOT NULL,
    quantity integer NOT NULL CHECK (quantity > 0),
    primary key (detail_id),
    FOREIGN KEY (order_id) REFERENCES tb_sales_order(order_id),
    FOREIGN KEY (warehouse_id) REFERENCES tb_warehouse(warehouse_id),
    FOREIGN KEY (book_id) REFERENCES tb_book(book_id)
);

-- 创建序列
create sequence tb_sales_detail_seq start with 1;
alter table tb_sales_detail alter column detail_id set default nextval('tb_sales_detail_seq');

-- 主要修改内容：
-- 1. INT -> integer
-- 2. AUTO_INCREMENT -> 使用序列和默认值
-- 3. DATETIME -> timestamp
-- 4. 添加显式的primary key声明
-- 5. COMMENT语法改为注释形式