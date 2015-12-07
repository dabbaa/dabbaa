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
  `ADDRESS_ID` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `pincode` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `UPDATED_BY` varchar(255) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`ADDRESS_ID`,`address`,`city`,`CREATED_BY`,`CREATED_ON`,`pincode`,`state`,`UPDATED_BY`,`UPDATED_ON`) VALUES 
 (1,'#1149, Sector 10,','Panchkual',NULL,NULL,131409,'Haryana',NULL,NULL);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `CUSTOMER_ID` int(11) NOT NULL,
  `COMMENT` varchar(255) DEFAULT NULL,
  `CONTACT_NO` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `UPDATED_BY` varchar(255) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`CUSTOMER_ID`,`COMMENT`,`CONTACT_NO`,`CREATED_BY`,`CREATED_ON`,`EMAIL_ID`,`FIRST_NAME`,`IS_ACTIVE`,`LAST_NAME`,`UPDATED_BY`,`UPDATED_ON`) VALUES 
 (1,NULL,'7508916892',NULL,NULL,'pawansoniara@gmai.com','Pawan',1,'Kashyap',NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `customer_address`
--

DROP TABLE IF EXISTS `customer_address`;
CREATE TABLE `customer_address` (
  `CUSTOMER_ID` int(11) NOT NULL,
  `ADDRESS_ID` int(11) NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`,`ADDRESS_ID`),
  KEY `FKqvog9bkc9c9elyf785v9qmkg1` (`ADDRESS_ID`),
  CONSTRAINT `FK91njd6py99yqeth3i9sbi19fq` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`),
  CONSTRAINT `FKqvog9bkc9c9elyf785v9qmkg1` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_address`
--

/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
INSERT INTO `customer_address` (`CUSTOMER_ID`,`ADDRESS_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `customer_address` ENABLE KEYS */;


--
-- Definition of table `customized_order`
--

DROP TABLE IF EXISTS `customized_order`;
CREATE TABLE `customized_order` (
  `CUSTOMIZED_ORDER_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(255) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `ADDRESS_ID` int(11) DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  `TIFFIN_TYPE_ID` int(11) DEFAULT NULL,
  `VENDOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMIZED_ORDER_ID`),
  KEY `FK3ww2igs61kscialsannpj5e6d` (`ADDRESS_ID`),
  KEY `FKnhsyu1j8u79a3udn7mnq0evwl` (`CUSTOMER_ID`),
  KEY `FKdg6djrfxixdy1dillngttc5a` (`TIFFIN_TYPE_ID`),
  KEY `FK50avm5peql76afmaqfw38oqef` (`VENDOR_ID`),
  CONSTRAINT `FK50avm5peql76afmaqfw38oqef` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FK3ww2igs61kscialsannpj5e6d` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`),
  CONSTRAINT `FKdg6djrfxixdy1dillngttc5a` FOREIGN KEY (`TIFFIN_TYPE_ID`) REFERENCES `tiffin_type` (`TIFFIN_TYPE_ID`),
  CONSTRAINT `FKnhsyu1j8u79a3udn7mnq0evwl` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`)
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
  `DAILY_ORDER_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `rate` double NOT NULL,
  `TIFFIN_DATE` date DEFAULT NULL,
  `UPDATED_BY` varchar(255) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `VENDOR_RATE` double DEFAULT NULL,
  `ADDRESS_ID` int(11) DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  `SCHEME_ID` int(11) DEFAULT NULL,
  `TIFFIN_TYPE_ID` int(11) DEFAULT NULL,
  `VENDOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DAILY_ORDER_ID`),
  KEY `FK1q8m78191qj9bg3g60e764epe` (`ADDRESS_ID`),
  KEY `FKacmywuv6exvwrqop0aj2kwxif` (`CUSTOMER_ID`),
  KEY `FKlom34qd5o2gjyl62cj2dnaxb8` (`SCHEME_ID`),
  KEY `FKf7kcykiod9la61pwwjajawvn7` (`TIFFIN_TYPE_ID`),
  KEY `FKehhoaqo4cav6s521gp9pwkgwo` (`VENDOR_ID`),
  CONSTRAINT `FKehhoaqo4cav6s521gp9pwkgwo` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FK1q8m78191qj9bg3g60e764epe` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`),
  CONSTRAINT `FKacmywuv6exvwrqop0aj2kwxif` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`),
  CONSTRAINT `FKf7kcykiod9la61pwwjajawvn7` FOREIGN KEY (`TIFFIN_TYPE_ID`) REFERENCES `tiffin_type` (`TIFFIN_TYPE_ID`),
  CONSTRAINT `FKlom34qd5o2gjyl62cj2dnaxb8` FOREIGN KEY (`SCHEME_ID`) REFERENCES `scheme` (`SCHEME_ID`)
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
  `FEEDBACK_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  `VENDOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`FEEDBACK_ID`),
  KEY `FKg7skws6uvclrreu5yryg0ubf` (`CUSTOMER_ID`),
  KEY `FK56292j6a3p6a380s5e17l1gvr` (`VENDOR_ID`),
  CONSTRAINT `FK56292j6a3p6a380s5e17l1gvr` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FKg7skws6uvclrreu5yryg0ubf` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;


--
-- Definition of table `issue`
--

DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `ISSUE_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `IS_SOLVED` tinyint(4) DEFAULT NULL,
  `issue` longtext,
  `UPDATED_BY` varchar(255) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  `VENDOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ISSUE_ID`),
  KEY `FKfsl3gqc7jakg8gwjwo8qp3caj` (`CUSTOMER_ID`),
  KEY `FKd5le25xga4w61d84ru4xpboj8` (`VENDOR_ID`),
  CONSTRAINT `FKd5le25xga4w61d84ru4xpboj8` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FKfsl3gqc7jakg8gwjwo8qp3caj` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`)
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
  `LOCATION_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `ADDRESS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LOCATION_ID`),
  KEY `FK5bu8qwrenebw4vqdbuutxrxd2` (`ADDRESS_ID`),
  CONSTRAINT `FK5bu8qwrenebw4vqdbuutxrxd2` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`LOCATION_ID`,`CREATED_BY`,`CREATED_ON`,`description`,`ADDRESS_ID`) VALUES 
 (1,NULL,NULL,'Panchkula',NULL);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;


--
-- Definition of table `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `MENU_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `description` longtext,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  `TIFFIN_TYPE_ID` int(11) DEFAULT NULL,
  `VENDOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`),
  KEY `FKfwf6r5s6plftsbat95hl799j0` (`TIFFIN_TYPE_ID`),
  KEY `FK68lrp6ngjdv28vh0r37uemjpq` (`VENDOR_ID`),
  CONSTRAINT `FK68lrp6ngjdv28vh0r37uemjpq` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FKfwf6r5s6plftsbat95hl799j0` FOREIGN KEY (`TIFFIN_TYPE_ID`) REFERENCES `tiffin_type` (`TIFFIN_TYPE_ID`)
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
  `ORDER_STATUS_ID` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ORDER_STATUS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_status`
--

/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` (`ORDER_STATUS_ID`,`description`) VALUES 
 (1,'NEW'),
 (2,'CONFIRM'),
 (3,'Delivered'),
 (4,'CANCEL');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;


--
-- Definition of table `rate`
--

DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate` (
  `RATE_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  `rate` double NOT NULL,
  `VENDOR_RATE` double DEFAULT NULL,
  `TIFFIN_TYPE_ID` int(11) DEFAULT NULL,
  `VENDOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RATE_ID`),
  KEY `FKi1uqkebwrvs35ruigewpootyy` (`TIFFIN_TYPE_ID`),
  KEY `FKp6tmxa4tbn2b10lgf9xmtrl1f` (`VENDOR_ID`),
  CONSTRAINT `FKp6tmxa4tbn2b10lgf9xmtrl1f` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FKi1uqkebwrvs35ruigewpootyy` FOREIGN KEY (`TIFFIN_TYPE_ID`) REFERENCES `tiffin_type` (`TIFFIN_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rate`
--

/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
INSERT INTO `rate` (`RATE_ID`,`CREATED_BY`,`CREATED_ON`,`description`,`IS_ACTIVE`,`rate`,`VENDOR_RATE`,`TIFFIN_TYPE_ID`,`VENDOR_ID`) VALUES 
 (1,NULL,NULL,'Lunch',1,55,50,2,1),
 (2,NULL,NULL,'Lunch',1,55,47,2,2);
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;


--
-- Definition of table `scheme`
--

DROP TABLE IF EXISTS `scheme`;
CREATE TABLE `scheme` (
  `SCHEME_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
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
  `TIFFIN_TYPE_ID` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TIFFIN_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`role_id`,`role`) VALUES 
 (1,'Admin'),
 (2,'operator'),
 (3,'customer');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_Id` int(11) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_Id`),
  KEY `FKqjp6iwe2anthe5yx88fl0coan` (`role_id`),
  CONSTRAINT `FKqjp6iwe2anthe5yx88fl0coan` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_Id`,`enabled`,`password`,`username`,`role_id`) VALUES 
 (1,1,'p@ssword','admin',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


--
-- Definition of table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor` (
  `VENDOR_ID` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `CONTACT_NO` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `UPDATED_BY` varchar(255) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`VENDOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor`
--

/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` (`VENDOR_ID`,`address`,`CONTACT_NO`,`CREATED_BY`,`CREATED_ON`,`EMAIL_ID`,`IS_ACTIVE`,`name`,`UPDATED_BY`,`UPDATED_ON`) VALUES 
 (1,'Pristan, Sector 7, Panchkula','9357676687',NULL,NULL,'vinayak.parashar@gmail.com',1,'Vinayak',NULL,NULL),
 (2,'Home Made Tiffin Service, Sector 20, Pannchkula','7837093149',NULL,NULL,NULL,1,'kavita',NULL,NULL);
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;


--
-- Definition of table `vendor_location`
--

DROP TABLE IF EXISTS `vendor_location`;
CREATE TABLE `vendor_location` (
  `VENDOR_ID` int(11) NOT NULL,
  `LOCATION_ID` int(11) NOT NULL,
  PRIMARY KEY (`VENDOR_ID`,`LOCATION_ID`),
  KEY `FKafdhdljpwhk25th41nnd1j1ge` (`LOCATION_ID`),
  CONSTRAINT `FKnlco44gqlqs5eogispowt4wun` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  CONSTRAINT `FKafdhdljpwhk25th41nnd1j1ge` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor_location`
--

/*!40000 ALTER TABLE `vendor_location` DISABLE KEYS */;
INSERT INTO `vendor_location` (`VENDOR_ID`,`LOCATION_ID`) VALUES 
 (1,1),
 (2,1);
/*!40000 ALTER TABLE `vendor_location` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
