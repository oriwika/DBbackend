-- 1. 图书类别表
CREATE TABLE tb_book_category (
   category_id INT PRIMARY KEY AUTO_INCREMENT,
   category_name VARCHAR(50) NOT NULL UNIQUE,
   description TEXT
);

-- 2. 出版社表
CREATE TABLE tb_publisher (
   publisher_id INT PRIMARY KEY AUTO_INCREMENT,
   publisher_name VARCHAR(100) NOT NULL UNIQUE,
   contact_phone VARCHAR(20),
   address TEXT
);

-- 3. 图书表
CREATE TABLE tb_book (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    category_id INT NOT NULL,
    publisher_id INT NOT NULL,
    purchase_price DECIMAL(10,2) COMMENT '进货价',
    retail_price DECIMAL(10,2) COMMENT '零售价',
    total_stock INT DEFAULT 0 COMMENT '总库存',
    FOREIGN KEY (category_id) REFERENCES tb_book_category(category_id),
    FOREIGN KEY (publisher_id) REFERENCES tb_publisher(publisher_id)
);

-- 4. 仓库表
CREATE TABLE tb_warehouse (
    warehouse_id INT PRIMARY KEY AUTO_INCREMENT,
    warehouse_name VARCHAR(50) NOT NULL UNIQUE,
    location VARCHAR(200),
    manager VARCHAR(50)
);

-- 5. 库存表
CREATE TABLE tb_inventory (
    book_id INT NOT NULL,
    warehouse_id INT NOT NULL,
    quantity INT DEFAULT 0 CHECK (quantity >= 0),
    PRIMARY KEY (book_id, warehouse_id),
    FOREIGN KEY (book_id) REFERENCES tb_book(book_id),
    FOREIGN KEY (warehouse_id) REFERENCES tb_warehouse(warehouse_id)
);

-- 6. 进货单主表
CREATE TABLE tb_purchase_order (
   order_id INT PRIMARY KEY AUTO_INCREMENT,
   order_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 7. 进货明细表（支持多本书）
CREATE TABLE tb_purchase_detail (
    detail_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    warehouse_id INT NOT NULL,  -- 新增仓库字段
    book_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    FOREIGN KEY (order_id) REFERENCES tb_purchase_order(order_id),
    FOREIGN KEY (warehouse_id) REFERENCES tb_warehouse(warehouse_id),
    FOREIGN KEY (book_id) REFERENCES tb_book(book_id)
);

-- 8. 销售单主表
CREATE TABLE tb_sales_order (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 9. 销售明细表（支持多本书）
CREATE TABLE tb_sales_detail (
    detail_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    warehouse_id INT NOT NULL,  -- 新增仓库字段
    book_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    FOREIGN KEY (order_id) REFERENCES tb_sales_order(order_id),
    FOREIGN KEY (warehouse_id) REFERENCES tb_warehouse(warehouse_id),
    FOREIGN KEY (book_id) REFERENCES tb_book(book_id)
);