-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


-- CREATE DATABASE "persaccounting" -------------------------------
CREATE DATABASE IF NOT EXISTS `persaccounting` CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `persaccounting`;

-- CREATE TABLE "commodity" —----------------------------------— 
CREATE TABLE `commodity` ( 
`id` Int( 255 ) AUTO_INCREMENT NOT NULL, 
`commodityName` VarChar( 40 ) NOT NULL, 
`commodityDescription` VarChar( 255 ) NULL, 
`commodityQuantityInStock` Double NULL, 
`commodityPriceWithoutTax` Double NULL, 
PRIMARY KEY ( `id` ) ) 
ENGINE = InnoDB; 
---------------------------------------------------------------— 


-- Dump data of "info" -------------------------------------
INSERT INTO `commodity`(`id`,`commodityName`,`commodityDescription`,`commodityQuantityInStock`,`commodityPriceWithoutTax`) VALUES ( '1', 'commodity_1', 'descr_1', '6.0', '8000.00' );
INSERT INTO `commodity`(`id`,`commodityName`,`commodityDescription`,`commodityQuantityInStock`,`commodityPriceWithoutTax`) VALUES ( '2', 'commodity_2', 'descr_2', '10.0', '5000.00' );
INSERT INTO `commodity`(`id`,`commodityName`,`commodityDescription`,`commodityQuantityInStock`,`commodityPriceWithoutTax`) VALUES ( '3', 'commodity_3', 'descr_2', '4.0', '50.00' );
-- ---------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------