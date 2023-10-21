
CREATE TABLE cached_logistic (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hash VARCHAR(255),
    courier VARCHAR(255),
    rate DOUBLE,
    error VARCHAR(255),
    httpStatus INT
) ENGINE=InnoDB;