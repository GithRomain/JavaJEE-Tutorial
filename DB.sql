drop database if exists studentdb;

create database if not exists studentdb;

use studentdb;

CREATE TABLE student(
                        id INT NOT NULL AUTO_INCREMENT,
                        first_name VARCHAR(50),
                        last_name VARCHAR(50),
                        email VARCHAR(50),
                        PRIMARY KEY(id)
);