create database warehouseVitamin;
use warehouseVitamin;

CREATE TABLE warehouse (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    is_active BOOLEAN DEFAULT 1,
    description  VARCHAR(200),
    create_by VARCHAR(50),
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE locators (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    is_active BOOLEAN DEFAULT 1,
    x DECIMAL(10,2),
    y DECIMAL(10,2),
    z DECIMAL(10,2),
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    create_by VARCHAR(50),
    warehouse_id INT,
    FOREIGN KEY (warehouse_id) REFERENCES warehouse(id)
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    is_active BOOLEAN DEFAULT 1,
    locator_id INT,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    create_by VARCHAR(50),
    qty_stock INT,
    product_type varchar(100) DEFAULT NULL,
    product_parent_id INT,
    FOREIGN KEY (locator_id) REFERENCES locators(id),
    FOREIGN KEY (product_parent_id) REFERENCES product(id)
);
INSERT INTO warehouse (name, is_active, description, create_by)
VALUES
    ('Kho Hà Nội', true, 'Kho chính chứa hàng điện tử', 'Nguyễn Văn A'),
    ('Kho Sài Gòn', true, 'Kho phụ chứa đồ nội thất', 'Trần Thị B'),
    ('Kho Đà Nẵng', true, 'Kho chứa quần áo', 'Lê Văn C'),
    ('Kho Hải Phòng', true, 'Kho dự phòng', 'Phạm Thị D'),
    ('Kho Cần Thơ', true, 'Kho chứa các vật dụng nhỏ', 'Ngô Văn E'),
    ('Kho Vũng Tàu', true, 'Kho chứa hàng hóa cồng kềnh', 'Nguyễn Thị F'),
    ('Kho Biên Hòa', true, 'Kho gần trung tâm thành phố', 'Đỗ Văn G'),
    ('Kho Nha Trang', true, 'Kho chứa hàng theo mùa', 'Vũ Thị H'),
    ('Kho Huế', true, 'Kho tạm thời', 'Phạm Văn I'),
    ('Kho Quy Nhơn', true, 'Kho chứa hàng tràn', 'Trần Thị J'),
    ('Kho Vĩnh Long', true, 'Kho chính chứa thực phẩm', 'Nguyễn Văn K'),
    ('Kho Sóc Trăng', true, 'Kho phụ chứa hàng điện tử', 'Lê Thị L'),
    ('Kho Nam Định', true, 'Kho chứa dụng cụ thể thao', 'Đinh Văn M'),
    ('Kho Bắc Ninh', true, 'Kho chứa đồ dã ngoại', 'Phạm Thị N'),
    ('Kho Quảng Ninh', true, 'Kho chứa văn phòng phẩm', 'Ngô Văn O'),
    ('Kho Thái Nguyên', true, 'Kho chứa đồ gia dụng', 'Nguyễn Thị P'),
    ('Kho Lạng Sơn', true, 'Kho chứa dụng cụ làm vườn', 'Trần Văn Q'),
    ('Kho Hà Nam', true, 'Kho chứa phụ tùng ô tô', 'Phạm Thị R'),
    ('Kho Thanh Hóa', true, 'Kho chứa sản phẩm dược phẩm', 'Lê Văn S'),
    ('Kho Nghệ An', true, 'Kho chứa đồ vệ sinh', 'Nguyễn Thị T'),
    ('Kho Hà Tĩnh', true, 'Kho chứa vật dụng cho thú cưng', 'Trần Văn U'),
    ('Kho Quảng Bình', true, 'Kho chứa sản phẩm cho trẻ em', 'Phạm Thị V'),
    ('Kho Quảng Trị', true, 'Kho chứa mỹ phẩm', 'Ngô Văn W'),
    ('Kho Thừa Thiên Huế', true, 'Kho chứa sản phẩm chăm sóc sức khỏe', 'Nguyễn Văn X'),
    ('Kho Bình Định', true, 'Kho chứa đồ gia dụng nhà bếp', 'Trần Thị Y'),
    ('Kho Phú Yên', true, 'Kho chứa đồ trang trí ngày lễ', 'Phạm Văn Z'),
    ('Kho Khánh Hòa', true, 'Kho chứa đồ chơi và trò chơi', 'Lê Thị A'),
    ('Kho Bình Thuận', true, 'Kho chứa sách và phương tiện truyền thông', 'Nguyễn Văn B'),
    ('Kho Ninh Thuận', true, 'Kho chứa đồ nội thất', 'Trần Văn C'),
    ('Kho Lâm Đồng', true, 'Kho chứa đồ giường và ga gối', 'Phạm Thị D');



INSERT INTO locators (name, x, y, z, create_by, warehouse_id)
VALUES 
('Kệ A1 - Kho Hà Nội', 10.5, 20.3, 30.7, 'Nguyễn Văn A', 1),
('Kệ A2 - Kho Hà Nội', 15.0, 25.4, 35.8, 'Nguyễn Văn A', 1),
('Kệ B1 - Kho Sài Gòn', 20.1, 30.5, 40.9, 'Trần Thị B', 2),
('Kệ B2 - Kho Sài Gòn', 25.2, 35.6, 45.0, 'Trần Thị B', 2),
('Kệ C1 - Kho Đà Nẵng', 30.3, 40.7, 50.1, 'Lê Văn C', 3),
('Kệ C2 - Kho Đà Nẵng', 35.4, 45.8, 55.2, 'Lê Văn C', 3),
('Kệ D1 - Kho Hải Phòng', 40.5, 50.9, 60.3, 'Phạm Thị D', 4),
('Kệ D2 - Kho Hải Phòng', 45.6, 55.0, 65.4, 'Phạm Thị D', 4),
('Kệ E1 - Kho Cần Thơ', 50.7, 60.1, 70.5, 'Ngô Văn E', 5),
('Kệ E2 - Kho Cần Thơ', 55.8, 65.2, 75.6, 'Ngô Văn E', 5),
('Kệ F1 - Kho Vũng Tàu', 60.9, 70.3, 80.7, 'Nguyễn Thị F', 6),
('Kệ F2 - Kho Vũng Tàu', 66.0, 75.4, 85.8, 'Nguyễn Thị F', 6),
('Kệ G1 - Kho Biên Hòa', 71.1, 80.5, 90.9, 'Đỗ Văn G', 7),
('Kệ G2 - Kho Biên Hòa', 76.2, 85.6, 96.0, 'Đỗ Văn G', 7),
('Kệ H1 - Kho Nha Trang', 81.3, 90.7, 101.1, 'Vũ Thị H', 8),
('Kệ H2 - Kho Nha Trang', 86.4, 95.8, 106.2, 'Vũ Thị H', 8),
('Kệ I1 - Kho Huế', 91.5, 100.9, 111.3, 'Phạm Văn I', 9),
('Kệ I2 - Kho Huế', 96.6, 106.0, 116.4, 'Phạm Văn I', 9),
('Kệ J1 - Kho Quy Nhơn', 101.7, 111.1, 121.5, 'Trần Thị J', 10),
('Kệ J2 - Kho Quy Nhơn', 106.8, 116.2, 126.6, 'Trần Thị J', 10),
('Kệ K1 - Kho Vĩnh Long', 111.9, 121.3, 131.7, 'Nguyễn Văn K', 11),
('Kệ K2 - Kho Vĩnh Long', 117.0, 126.4, 136.8, 'Nguyễn Văn K', 11),
('Kệ L1 - Kho Sóc Trăng', 122.1, 131.5, 141.9, 'Lê Thị L', 12),
('Kệ L2 - Kho Sóc Trăng', 127.2, 136.6, 147.0, 'Lê Thị L', 12),
('Kệ M1 - Kho Nam Định', 132.3, 141.7, 152.1, 'Đinh Văn M', 13),
('Kệ M2 - Kho Nam Định', 137.4, 146.8, 157.2, 'Đinh Văn M', 13),
('Kệ N1 - Kho Bắc Ninh', 142.5, 151.9, 162.3, 'Phạm Thị N', 14),
('Kệ N2 - Kho Bắc Ninh', 147.6, 157.0, 167.4, 'Phạm Thị N', 14),
('Kệ O1 - Kho Quảng Ninh', 152.7, 162.1, 172.5, 'Ngô Văn O', 15),
('Kệ O2 - Kho Quảng Ninh', 157.8, 167.2, 177.6, 'Ngô Văn O', 15);

INSERT INTO product (name, is_active, locator_id, create_by, qty_stock, product_type, product_parent_id)
VALUES 
('Bộ máy tính văn phòng', 1, 1, 'Nguyễn Văn A', 100, 'combo', NULL),
('Màn hình Dell 24 inch', 1, 1, 'Nguyễn Văn A', 200, 'item', 1),
('Bàn phím cơ Logitech', 1, 2, 'Trần Thị B', 150, 'item', 1),
('Chuột không dây Logitech', 1, 2, 'Trần Thị B', 150, 'item', 1),
('Bộ bàn ghế học sinh', 1, 3, 'Lê Văn C', 50, 'combo', NULL),
('Bàn học sinh gỗ thông', 1, 3, 'Lê Văn C', 75, 'item', 5),
('Ghế học sinh nhựa', 1, 4, 'Phạm Thị D', 100, 'item', 5),
('Tivi Samsung 55 inch', 1, 4, 'Phạm Thị D', 80, 'item', NULL),
('Dàn âm thanh Sony', 1, 5, 'Ngô Văn E', 60, 'combo', NULL),
('Loa Sony Bluetooth', 1, 5, 'Ngô Văn E', 120, 'item', 9),
('Laptop Asus Vivobook', 1, 6, 'Nguyễn Thị F', 90, 'item', NULL),
('Điện thoại iPhone 14', 1, 6, 'Nguyễn Thị F', 70, 'item', NULL),
('Máy lạnh Daikin 1.5 HP', 1, 7, 'Đỗ Văn G', 50, 'item', NULL),
('Quạt điều hòa Sunhouse', 1, 7, 'Đỗ Văn G', 40, 'item', NULL),
('Máy giặt LG 8kg', 1, 8, 'Vũ Thị H', 60, 'item', NULL),
('Bếp từ đôi Kangaroo', 1, 8, 'Vũ Thị H', 100, 'item', NULL),
('Bộ nồi inox Sunhouse', 1, 9, 'Phạm Văn I', 80, 'combo', NULL),
('Nồi cơm điện Sharp', 1, 9, 'Phạm Văn I', 120, 'item', 17),
('Máy xay sinh tố Philips', 1, 10, 'Trần Thị J', 90, 'item', NULL),
('Bình đun siêu tốc Philips', 1, 10, 'Trần Thị J', 100, 'item', NULL),
('Tủ lạnh Samsung 300L', 1, 11, 'Nguyễn Văn K', 30, 'item', NULL),
('Lò vi sóng Electrolux', 1, 11, 'Nguyễn Văn K', 50, 'item', NULL),
('Bộ dụng cụ sửa chữa', 1, 12, 'Lê Thị L', 70, 'combo', NULL),
('Tô vít đa năng', 1, 12, 'Lê Thị L', 120, 'item', 23),
('Cây lau nhà đa năng', 1, 13, 'Đinh Văn M', 110, 'item', NULL),
('Máy hút bụi Electrolux', 1, 13, 'Đinh Văn M', 90, 'item', NULL),
('Giường gỗ sồi', 1, 14, 'Phạm Thị N', 30, 'item', NULL),
('Tủ quần áo 4 cánh', 1, 14, 'Phạm Thị N', 20, 'item', NULL),
('Bộ ghế sofa da thật', 1, 15, 'Ngô Văn O', 15, 'combo', NULL),
('Bàn trà gỗ công nghiệp', 1, 15, 'Ngô Văn O', 20, 'item', 29);

select id,
name,
is_active,
description,
create_by,
created
 from warehouse;

update warehouse 
set name = 'kho TPHCM',
 is_active = true,
 description = 'kho chua laptop', 
 create_by = 'Quang',
 created = '2024-08-22 12:56:08'
 where id = 34;
 
 
delete from warehouse where id = 35;

select
 id,
 name,
 is_active
 ,x,y,z,
 created,
 create_by,
 warehouse_id
 from locators;
 
 
 INSERT INTO locators
    (name, is_active, x, y, z, create_by, warehouse_id)
VALUES 
    ("Kệ A1 - Kho TPHCM",
     true,
	10.5, 20.3, 30.7,
     "Thanh", 
     2);

update locators 
set name = "Kệ A1 - Kho Nghe An",
is_active = 0,
x = 220,
y = 103,
z = 301,
created = '2024-08-22 11:37:16',
create_by = 'Long',
warehouse_id = 3
where id = 31;

delete from locators 
where id = 32;


select * from product where product_type = 'combo';