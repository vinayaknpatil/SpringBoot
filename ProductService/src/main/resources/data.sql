DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(1000),
  description VARCHAR(1000)
);

INSERT INTO PRODUCT(category, description) VALUES
('Electronics', 'New Mac laptop');

INSERT INTO PRODUCT(category, description) VALUES
('Personal', 'Wallet');

INSERT INTO PRODUCT(category, description) VALUES
('Electronics', 'Mobile');