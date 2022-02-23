CREATE DATABASE bms2;


 CREATE TABLE customer_details(account_no INT,name VARCHAR(20), password INT, balance DOUBLE PRECISION);
						 
INSERT INTO customer_details(account_no,name,password,balance)VALUES(101,'JOY',111,950.0);
INSERT INTO customer_details(account_no,name,password,balance)VALUES(102,'adel',222,950.0);
INSERT INTO customer_details(account_no,name,password,balance)VALUES(103,'hass',333,550.0);

 
 CREATE TABLE employee_details(name VARCHAR(20), password INT);				 
						  
INSERT INTO employee_details(name,password)VALUES('apl',111);
INSERT INTO employee_details(name,password)VALUES('alic',222);
INSERT INTO employee_details(name,password)VALUES('ali',333);

