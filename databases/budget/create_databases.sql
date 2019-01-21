DROP DATABASE IF EXISTS budget_dev;
DROP DATABASE IF EXISTS budget_test;

CREATE DATABASE budget_dev;
CREATE DATABASE budget_test;

CREATE USER IF NOT EXISTS 'budget'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON budget_dev.* TO 'budget' @'localhost';
GRANT ALL PRIVILEGES ON budget_test.* TO 'budget' @'localhost';