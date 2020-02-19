CREATE DATABASE tours_db;

CREATE TABLE tours_db.tours(
   id INT NOT NULL AUTO_INCREMENT,
   tour_id LONG NOT NULL,
   tour_type VARCHAR(50) NOT NULL,
   price FLOAT(25) ,
   transport_type VARCHAR(25),
   type_of_food VARCHAR(25),
   amount_of_days INT(20),
   PRIMARY KEY (ID)
);