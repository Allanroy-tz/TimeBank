# CREATE DATABASE  IF NOT EXISTS `timebank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
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
-- Table structure for table `timeorder`
--

DROP TABLE IF EXISTS `timeorder`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `timeorder`
(
    `OrderId`      int NOT NULL AUTO_INCREMENT,
    `OpenId`       varchar(45) DEFAULT NULL,
    `Tittle`       varchar(45) DEFAULT NULL,
    `AcceptOpenId` varchar(45) DEFAULT NULL,
    `Description`  varchar(45) DEFAULT NULL,
    `TimeSpent`    int         DEFAULT NULL,
    `Position`     varchar(45) DEFAULT NULL,
    `DateTime`     varchar(45) DEFAULT NULL,
    `OrderState`   varchar(2)  DEFAULT NULL COMMENT '-1:未完成\n0:待接单\n1:已接单\n2:已完成',
    PRIMARY KEY (`OrderId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 15
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeorder`
--

LOCK TABLES `timeorder` WRITE;
/*!40000 ALTER TABLE `timeorder`
    DISABLE KEYS */;
INSERT INTO `timeorder`
VALUES (1, '12333', '111', '0000000', '2222', 100, '-----', '2024-10-1 10:20', '2'),
       (2, '12333', '111', '0000000', '2222', 100, '-----', '2024-10-1 10:20', '2'),
       (3, '12333', '111', '0000000', '2222', 100, '-----', '2024-10-1 10:20', '2'),
       (4, '12333', '111', '0000000', '2222', 100, '-----', '2024-10-1 10:20', '1'),
       (5, '12333', '111', '', '2222', 100, '-----', '2024-10-1 10:20', '0'),
       (6, '12333', '111', NULL, '2222', 100, '-----', '2024-10-1 10:20', '0'),
       (7, '0000000', '12313', NULL, '12313', 123, '---------', '2020-01-10 10:10', '-3'),
       (8, '0000000', '2222', NULL, '44444', 222, '333', '2024-05-17 00:00', '-3'),
       (9, '0000000', '12233', NULL, '1111', 444, '3333', '2024-05-17 00:00', '-3'),
       (10, '0000000', '打扫卫生', NULL, '一屋不扫，何以扫天下。是吗？', 60, '南华大学', '2024-05-17 04:00', '0'),
       (11, '0000000', '1333', NULL, '11111111111111', 444, '33', '2024-05-17 00:00', '-3'),
       (12, '0000000', '12313', NULL, 'description', 1123, 'position', 'dateTime', '-2'),
       (13, '123123', '2222', '12222', '1222', 2222, '222222', '2024-02-02', '1'),
       (14, '123321', 'ooo', NULL, '2222', 100, '---------', '2024-10-20 10:20', '-1');
/*!40000 ALTER TABLE `timeorder`
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
