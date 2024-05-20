CREATE DATABASE IF NOT EXISTS `timebank` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `timebank`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: timebank
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `user`
(
    `OpenId`          varchar(45) NOT NULL,
    `UserName`        varchar(45)                                            DEFAULT NULL,
    `Phone`           varchar(11)                                            DEFAULT NULL,
    `AccountId`       varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `AccountPassword` varchar(45)                                            DEFAULT NULL,
    `TimeCredits`     int                                                    DEFAULT NULL,
    PRIMARY KEY (`OpenId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user`
    DISABLE KEYS */;
INSERT INTO `user`
VALUES ('0000000', 'Allanroy', '18711857372', '222222222', '3333333333', 1500),
       ('123122', '123123', '123123', '33', '23', 1233),
       ('123123', 'testname', '12312312311', '123123123123123', '12313123123', 4444),
       ('12333', '12333', '12333331122', '33333333333', '222222222222', 10611),
       ('1782316887787446273', 'testName', '18711857372', '2222222222222222222', '222233333333333333', 2000),
       ('1782323708258418689', 'testName', '18711857372', '2222222222222222222', '222233333333333333', 2000),
       ('1792244719204462594', 'testName', '18711857372', '2222222222222222222', '222233333333333333', 2000),
       ('openId', 'userName', 'phone', 'accountId', 'accountPassword', 500);
/*!40000 ALTER TABLE `user`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2024-05-20  1:39:26
