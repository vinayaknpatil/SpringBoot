DROP TABLE IF EXISTS PRODUCT_NAME;

CREATE TABLE PRODUCT_NAME (
  id INT PRIMARY KEY,
  product_name varchar(100)
);

INSERT INTO PRODUCT_NAME(id, product_name) VALUES
(1, 'Mac Laptop');

INSERT INTO PRODUCT_NAME(id, product_name) VALUES
(2, 'Wallet');

INSERT INTO PRODUCT_NAME(id, product_name) VALUES
(3, 'Mobile');