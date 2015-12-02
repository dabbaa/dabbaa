-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.22


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema dabbaawala
--

CREATE DATABASE IF NOT EXISTS dabbaawala;
USE dabbaawala;

--
-- Definition of table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `ADDRESS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `pincode` int(11) NOT NULL,
  `state` varchar(45) DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMENT` varchar(100) DEFAULT NULL,
  `CONTACT_NO` varchar(12) NOT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `EMAIL_ID` varchar(45) DEFAULT NULL,
  `FIRST_NAME` varchar(45) NOT NULL,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `customer_address`
--

DROP TABLE IF EXISTS `customer_address`;
CREATE TABLE `customer_address` (
  `CUSTOMER_ID` int(11) NOT NULL,
  `ADDRESS_ID` int(11) NOT NULL,
  KEY `FKmun59059kb5l8e4n8ne3fegmx` (`ADDRESS_ID`),
  KEY `FK1pcqqkt9g8qtfv28oy6h35p1q` (`CUSTOMER_ID`),
  CONSTRAINT `FK1pcqqkt9g8qtfv28oy6h35p1q` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`),
  CONSTRAINT `FKmun59059kb5l8e4n8ne3fegmx` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_address`
--

/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_address` ENABLE KEYS */;


--
-- Definition of table `customized_order`
--

DROP TABLE IF EXISTS `customized_order`;
CREATE TABLE `customized_order` (
  `CUSTOMIZED_ORDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `ADDRESS_ID` int(11) NOT NULL,
  `CUSTOMER_ID` int(11) NOT NULL,
  `TIFFIN_TYPE_ID` int(11) NOT NULL,
  `VENDOR_ID` int(11) NOT NULL,
  PRIMARY KEY (`CUSTOMIZED_ORDER_ID`),
  KEY `FKeutgohxu4jgep63jswkj2rfg2` (`ADDRESS_ID`),
  KEY `FK3jkkp2fkikv4r1pd7yipxjmg5` (`CUSTOMER_ID`),
  KEY `FKdg6djrfxixdy1dillngttc5a` (`TIFFIN_TYPE_ID`),
  KEY `FKh1klmskdw8ge0011jwurqfj4t` (`VENDOR_ID`),
  CONSTRAINT `FK3jkkp2fkikv4r1pd7yipxjmg5` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`),
  CONSTRAINT `FKdg6djrfxixdy1dillngttc5a` FOREIGN KEY (`TIFFIN_TYPE_ID`) REFERENCES `tiffin_type` (`TIFFIN_TYPE_ID`),
  CONSTRAINT `FKeutgohxu4jgep63jswkj2rfg2` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`),
  CONSTRAINT `FKh1klmskdw8ge0011jwurqfj4t` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customized_order`
--

/*!40000 ALTER TABLE `customized_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `customized_order` ENABLE KEYS */;


--
-- Definition of table `daily_order`
--

DROP TABLE IF EXISTS `daily_order`;
CREATE TABLE `daily_order` (
  `DAILY_ORDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `rate` double NOT NULL,
  `TIFFIN_DATE` date NOT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `VENDOR_RATE` double NOT NULL,
  `ADDRESS_ID` int(11) NOT NULL,
  `CUSTOMER_ID` int(11) NOT NULL,
  `SCHEME_ID` int(11) DEFAULT NULL,
  `TIFFIN_TYPE_ID` int(11) NOT NULL,
  `VENDOR_ID` int(11) NOT NULL,
  PRIMARY KEY (`DAILY_ORDER_ID`),
  KEY `FK4r4nqtlbsk6cveleywepmyigq` (`ADDRESS_ID`),
  KEY `FKru8eytngh6m8gu9j684myoxr5` (`CUSTOMER_ID`),
  KEY `FK5kpok3tu8hnc8wygoxab0w9m2` (`SCHEME_ID`),
  KEY `FKf7kcykiod9la61pwwjajawvn7` (`TIFFIN_TYPE_ID`),
  KEY `FK3k6i7of5pg5s7ttbwhe5lolbn` (`VENDOR_ID`),
  CONSTRAINT `FK3k6i7of5pg5s7ttbwhe5lolbn` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FK4r4nqtlbsk6cveleywepmyigq` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`),
  CONSTRAINT `FK5kpok3tu8hnc8wygoxab0w9m2` FOREIGN KEY (`SCHEME_ID`) REFERENCES `scheme` (`SCHEME_ID`),
  CONSTRAINT `FKf7kcykiod9la61pwwjajawvn7` FOREIGN KEY (`TIFFIN_TYPE_ID`) REFERENCES `tiffin_type` (`TIFFIN_TYPE_ID`),
  CONSTRAINT `FKru8eytngh6m8gu9j684myoxr5` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `daily_order`
--

/*!40000 ALTER TABLE `daily_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_order` ENABLE KEYS */;


--
-- Definition of table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `FEEDBACK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `CUSTOMER_ID` int(11) NOT NULL,
  `VENDOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`FEEDBACK_ID`),
  KEY `FKplxskiuigvh8st6n2baieekyt` (`CUSTOMER_ID`),
  KEY `FK52hkbq8oa3jrb7yqj1w12gm5` (`VENDOR_ID`),
  CONSTRAINT `FK52hkbq8oa3jrb7yqj1w12gm5` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FKplxskiuigvh8st6n2baieekyt` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;


--
-- Definition of table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES 
 (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;


--
-- Definition of table `issue`
--

DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `ISSUE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `IS_SOLVED` tinyint(4) DEFAULT NULL,
  `issue` longtext NOT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `CUSTOMER_ID` int(11) NOT NULL,
  `VENDOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ISSUE_ID`),
  KEY `FKrv1w435a2x39c08qipdpuvh3q` (`CUSTOMER_ID`),
  KEY `FKm8i73ay82sdvqlcd6a0anbegv` (`VENDOR_ID`),
  CONSTRAINT `FKm8i73ay82sdvqlcd6a0anbegv` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FKrv1w435a2x39c08qipdpuvh3q` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue`
--

/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;


--
-- Definition of table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `LOCATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `description` varchar(45) NOT NULL,
  `ADDRESS_ID` int(11) NOT NULL,
  PRIMARY KEY (`LOCATION_ID`),
  KEY `FK4bs65v7swmj6kojb2q7t98owc` (`ADDRESS_ID`),
  CONSTRAINT `FK4bs65v7swmj6kojb2q7t98owc` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;


--
-- Definition of table `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `MENU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `description` longtext NOT NULL,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  `TIFFIN_TYPE_ID` int(11) NOT NULL,
  `VENDOR_ID` int(11) NOT NULL,
  PRIMARY KEY (`MENU_ID`),
  KEY `FKe0j2c0l9oxloguebiqqu60gii` (`TIFFIN_TYPE_ID`),
  KEY `FKtj8nr64qxjybhj2bnx0kk2ykh` (`VENDOR_ID`),
  CONSTRAINT `FKe0j2c0l9oxloguebiqqu60gii` FOREIGN KEY (`TIFFIN_TYPE_ID`) REFERENCES `tiffin_type` (`TIFFIN_TYPE_ID`),
  CONSTRAINT `FKtj8nr64qxjybhj2bnx0kk2ykh` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;


--
-- Definition of table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `ORDER_STATUS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`ORDER_STATUS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_status`
--

/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;


--
-- Definition of table `rate`
--

DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate` (
  `RATE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(45) NOT NULL,
  `CREATED_ON` datetime NOT NULL,
  `description` varchar(45) NOT NULL,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  `rate` double NOT NULL,
  `VENDOR_RATE` double NOT NULL,
  `TIFFIN_TYPE_ID` int(11) NOT NULL,
  `VENDOR_ID` int(11) NOT NULL,
  PRIMARY KEY (`RATE_ID`),
  KEY `FKcqq2fvocfcbbp5c0a8ucycdlg` (`TIFFIN_TYPE_ID`),
  KEY `FKrienxwp9tucd9vtefacsy5ww1` (`VENDOR_ID`),
  CONSTRAINT `FKcqq2fvocfcbbp5c0a8ucycdlg` FOREIGN KEY (`TIFFIN_TYPE_ID`) REFERENCES `tiffin_type` (`TIFFIN_TYPE_ID`),
  CONSTRAINT `FKrienxwp9tucd9vtefacsy5ww1` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rate`
--

/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;


--
-- Definition of table `role_master`
--

DROP TABLE IF EXISTS `role_master`;
CREATE TABLE `role_master` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `UK_1g9j09mbmwtc5tjh6nmyridjr` (`roleName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role_master`
--

/*!40000 ALTER TABLE `role_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_master` ENABLE KEYS */;


--
-- Definition of table `scheme`
--

DROP TABLE IF EXISTS `scheme`;
CREATE TABLE `scheme` (
  `SCHEME_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `description` varchar(45) NOT NULL,
  `discount` double NOT NULL,
  `EXTRA_COST` double DEFAULT NULL,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`SCHEME_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `scheme`
--

/*!40000 ALTER TABLE `scheme` DISABLE KEYS */;
/*!40000 ALTER TABLE `scheme` ENABLE KEYS */;


--
-- Definition of table `tiffin_type`
--

DROP TABLE IF EXISTS `tiffin_type`;
CREATE TABLE `tiffin_type` (
  `TIFFIN_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`TIFFIN_TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tiffin_type`
--

/*!40000 ALTER TABLE `tiffin_type` DISABLE KEYS */;
INSERT INTO `tiffin_type` (`TIFFIN_TYPE_ID`,`description`) VALUES 
 (1,'Breakfast'),
 (2,'Lunch'),
 (3,'Dinner');
/*!40000 ALTER TABLE `tiffin_type` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(60) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_Id`),
  KEY `FK_users_1` (`role_id`),
  CONSTRAINT `FK_users_1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


--
-- Definition of table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor` (
  `VENDOR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(45) NOT NULL,
  `CONTACT_NO` varchar(12) NOT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `EMAIL_ID` varchar(45) DEFAULT NULL,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`VENDOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor`
--

/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;


--
-- Definition of table `vendor_location`
--

DROP TABLE IF EXISTS `vendor_location`;
CREATE TABLE `vendor_location` (
  `VENDOR_ID` int(11) NOT NULL,
  `LOCATION_ID` int(11) NOT NULL,
  KEY `FKfm46svcy0tf5w7t722f5wnkd2` (`LOCATION_ID`),
  KEY `FKlqwl8k64bibg3l8oqj1x0y6kc` (`VENDOR_ID`),
  CONSTRAINT `FKfm46svcy0tf5w7t722f5wnkd2` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`LOCATION_ID`),
  CONSTRAINT `FKlqwl8k64bibg3l8oqj1x0y6kc` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor_location`
--

/*!40000 ALTER TABLE `vendor_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_location` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
