/* DELETE 'productsDB' database*/
DROP SCHEMA easybooking;
/* DELETE USER 'products_user' AT LOCAL SERVER*/
DROP USER 'easybooking_user'@'%';

/* CREATE ''productsDB' DATABASE */
CREATE SCHEMA easybooking;
/* CREATE THE USER 'products_user' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER 'easybooking_user'@'%' IDENTIFIED BY 'password';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'products_user' AT LOCAL SERVER*/
GRANT ALL ON easybooking.* TO 'easybooking_user'@'%';
