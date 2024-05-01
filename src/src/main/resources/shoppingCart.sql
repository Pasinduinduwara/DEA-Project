show databases;
use shoppingCart;
CREATE TABLE cart (
    userName VARCHAR(255) NOT NULL,
    productId INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (userName, productId)
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stockAmount DECIMAL(10, 2) NOT NULL,
    discounts DECIMAL(10, 2) NOT NULL,
    images TEXT,
    description TEXT,
    category VARCHAR(255)
);

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Inserting a record with id 2526
INSERT INTO users (email, userName, password, role) 
VALUES ('pasinduinduwarak19@gmail.com', 'induwara', 'Ige6#dpi', 'admin');

-- Inserting a record with id 2527
INSERT INTO users (email, userName, password, role) 
VALUES ('askarunanayaka@gmail.com', 'ayodhya', 'sasanka', 'user');

-- Inserting a record with id 2528
INSERT INTO users (email, userName, password, role) 
VALUES ('hasarasathsara@gmail.com', 'pasi123', 'dea123', 'user');


SELECT * FROM user;
select * from product;
select * from cart;




