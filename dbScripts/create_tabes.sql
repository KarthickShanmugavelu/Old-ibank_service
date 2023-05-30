CREATE DATABASE  IF NOT EXISTS `bank_database`;
USE `bank_database`;
--
-- Defining table 'Accounts'
--

DROP TABLE IF EXISTS `Accounts`;

CREATE TABLE `Accounts` (
  `ACCOUNT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_NAME` varchar(45) DEFAULT NULL,
  `PHONE` int(10),
  `EMAIL` varchar(45) DEFAULT NULL,
  `STATUS` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Inserting data into for table `Accounts`
--

LOCK TABLES `Accounts` WRITE;

INSERT INTO `Accounts` VALUES 
	(1,'Vinod',12345,'vinod@ibank.com','Active'),
	(2,'Hafeez',23456,'hafeez@ibank.com','Active'),
    (3,'Gobi',6543,'gobi@ibank.com','Active');

UNLOCK TABLES;

--
-- Defining table 'Beneficiary'
--

DROP TABLE IF EXISTS `Beneficiary`;

CREATE TABLE `Beneficiary` (
  `ACCOUNT_ID` int(11),
  `BENE_ACCOUNT_ID` int(20),
  `BENE_IFSCCODE` varchar(45) DEFAULT NULL,
  `BENE_NAME` varchar(45) DEFAULT NULL,
  `STATUS` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data into for table `Beneficiary`
--

LOCK TABLES `Beneficiary` WRITE;

INSERT INTO `Beneficiary` VALUES 
	(1,123094355,'IFSC00001','Sample 1','Active'),
	(1,444535466,'IFSC00002','Sample 2','Inactive'),
    (2,75443554,'ISFC0003','Sample 3','Active');

UNLOCK TABLES;

--
-- Defining table 'Transactions'
--

DROP TABLE IF EXISTS `Transactions`;

CREATE TABLE `Transactions` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
  `Account_Id` int(11),
  `Date` varchar(45) DEFAULT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `Amount` BIGINT,
  `Status` varchar(45) DEFAULT NULL,
  `Remarks` longtext,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Inserting data into for table `Transactions`
--

LOCK TABLES `Transactions` WRITE;

INSERT INTO `Transactions` VALUES 
	(1,1,'18-Sep-22','Credit',1000,'Success',null),
	(2,1,'18-Sep-22','Debit',500,'Failure',null),
    (3,2,'19-Sep-22','Credit',5000,'Success',null),
    (4,3,'19-Sep-22','Debit',1000,'Success',null);

UNLOCK TABLES;

USE `bank_database`;
--
-- Defining table 'Account_Balance'
--

DROP TABLE IF EXISTS `Account_Balance`;

CREATE TABLE `Account_Balance` (
  `Account_Id` int(11),
  `Balance` BIGINT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data into for table `Account_Balance`
--

LOCK TABLES `Account_Balance` WRITE;

INSERT INTO `Account_Balance` VALUES 
	(1,10000),
	(2,5000),
    (3,3000);

UNLOCK TABLES;