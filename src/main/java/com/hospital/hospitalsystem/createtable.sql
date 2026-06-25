-- Paste this into an sql database
-- You may need to modify the information found in the dbManager class to connect your database properly

CREATE TABLE IF NOT EXISTS users (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
name varchar(255) NOT NULL,
email varchar(255) NOT NULL,
age TINYINT NOT NULL,
gender varchar(255) NOT NULL,
role varchar(255) NOT NULL);