-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: irctc
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `coach_type`
--

LOCK TABLES `coach_type` WRITE;
/*!40000 ALTER TABLE `coach_type` DISABLE KEYS */;
INSERT INTO `coach_type` VALUES (1,'GEN',70,35,35,2.00,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(2,'SL',42,21,21,4.00,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(3,'CC',70,35,35,8.00,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(4,'AC1',24,12,12,22.00,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(5,'AC2',36,18,18,16.00,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(6,'AC3',42,21,21,12.00,'2020-06-23 11:38:05','2020-06-23 11:38:05');
/*!40000 ALTER TABLE `coach_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `passenger_type`
--

LOCK TABLES `passenger_type` WRITE;
/*!40000 ALTER TABLE `passenger_type` DISABLE KEYS */;
INSERT INTO `passenger_type` VALUES (1,'MINOR','for children below 5 yrs',50.00,NULL,NULL),(2,'SENIOR_CITIZEN','for citizens above 58 yrs of age',25.00,NULL,NULL),(3,'DISABLED','for physically disabled people',30.00,NULL,NULL),(4,'NONE','no concession',0.00,NULL,NULL),(5,'MILITARY','for currently serving military personnel',10.00,NULL,NULL),(6,'FREEDOM_FIGHTER','freedom fighter ',50.00,NULL,NULL);
/*!40000 ALTER TABLE `passenger_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `seat_availability`
--

LOCK TABLES `seat_availability` WRITE;
/*!40000 ALTER TABLE `seat_availability` DISABLE KEYS */;
/*!40000 ALTER TABLE `seat_availability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `station_details`
--

LOCK TABLES `station_details` WRITE;
/*!40000 ALTER TABLE `station_details` DISABLE KEYS */;
INSERT INTO `station_details` VALUES (1,'ST1','StationName1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(2,'ST2','StationName2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(3,'ST3','StationName3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(4,'ST4','StationName4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(5,'ST5','StationName5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(6,'ST6','StationName6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(7,'ST7','StationName7','2020-06-23 11:38:05','2020-06-23 11:38:05'),(8,'ST8','StationName8','2020-06-23 11:38:05','2020-06-23 11:38:05'),(9,'ST9','StationName9','2020-06-23 11:38:05','2020-06-23 11:38:05'),(10,'ST10','StationName10','2020-06-23 11:38:05','2020-06-23 11:38:05'),(11,'ST11','StationName11','2020-06-23 11:38:05','2020-06-23 11:38:05'),(12,'ST12','StationName12','2020-06-23 11:38:05','2020-06-23 11:38:05'),(13,'ST13','StationName13','2020-06-23 11:38:05','2020-06-23 11:38:05'),(14,'ST14','StationName14','2020-06-23 11:38:05','2020-06-23 11:38:05'),(15,'ST15','StationName15','2020-06-23 11:38:05','2020-06-23 11:38:05'),(16,'ST16','StationName16','2020-06-23 11:38:05','2020-06-23 11:38:05'),(17,'ST17','StationName17','2020-06-23 11:38:05','2020-06-23 11:38:05'),(18,'ST18','StationName18','2020-06-23 11:38:05','2020-06-23 11:38:05'),(19,'ST19','StationName19','2020-06-23 11:38:05','2020-06-23 11:38:05'),(20,'ST20','StationName20','2020-06-23 11:38:05','2020-06-23 11:38:05'),(21,'ST21','StationName21','2020-06-23 11:38:05','2020-06-23 11:38:05'),(22,'ST22','StationName22','2020-06-23 11:38:05','2020-06-23 11:38:05'),(23,'ST23','StationName23','2020-06-23 11:38:05','2020-06-23 11:38:05'),(24,'ST24','StationName24','2020-06-23 11:38:05','2020-06-23 11:38:05'),(25,'ST25','StationName25','2020-06-23 11:38:05','2020-06-23 11:38:05');
/*!40000 ALTER TABLE `station_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `train_coach`
--

LOCK TABLES `train_coach` WRITE;
/*!40000 ALTER TABLE `train_coach` DISABLE KEYS */;
INSERT INTO `train_coach` VALUES (1,1,1,'GE1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(2,1,2,'SL1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(3,1,3,'CC1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(4,1,4,'HA1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(5,1,5,'A1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(6,1,6,'B1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(7,1,1,'GE2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(8,1,2,'SL2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(9,1,3,'CC2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(10,1,4,'HA2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(11,1,5,'A2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(12,1,6,'B2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(13,2,1,'GE1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(14,2,2,'SL1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(15,2,3,'CC1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(16,2,4,'HA1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(17,2,5,'A1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(18,2,6,'B1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(19,2,1,'GE2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(20,2,2,'SL2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(21,2,3,'CC2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(22,2,4,'HA2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(23,2,5,'A2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(24,2,6,'B2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(25,3,1,'GE1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(26,3,1,'GE2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(27,3,1,'GE3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(28,3,1,'GE4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(29,3,1,'GE5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(30,3,1,'GE6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(31,3,1,'GE7','2020-06-23 11:38:05','2020-06-23 11:38:05'),(32,3,2,'SL1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(33,3,2,'SL2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(34,3,2,'SL3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(35,3,2,'SL4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(36,3,2,'SL5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(37,3,2,'SL6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(38,3,2,'SL7','2020-06-23 11:38:05','2020-06-23 11:38:05'),(39,3,2,'SL8','2020-06-23 11:38:05','2020-06-23 11:38:05'),(40,3,3,'CC1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(41,3,3,'CC2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(42,3,4,'HA1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(43,3,5,'A1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(44,3,5,'A2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(45,3,5,'A3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(46,3,6,'B3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(47,3,6,'B4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(48,3,6,'B5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(49,3,6,'B6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(50,3,6,'B7','2020-06-23 11:38:05','2020-06-23 11:38:05'),(51,4,3,'CC1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(52,4,3,'CC2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(53,4,3,'CC3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(54,4,3,'CC4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(55,4,3,'CC5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(56,4,3,'CC6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(57,4,5,'A1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(58,4,5,'A2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(59,4,5,'A3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(60,4,5,'A4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(61,4,5,'A5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(62,4,5,'A6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(63,4,5,'A7','2020-06-23 11:38:05','2020-06-23 11:38:05'),(64,4,5,'A8','2020-06-23 11:38:05','2020-06-23 11:38:05'),(65,4,6,'B1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(66,4,6,'B2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(67,4,6,'B3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(68,4,6,'B4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(69,4,6,'B5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(70,4,6,'B6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(71,4,6,'B7','2020-06-23 11:38:05','2020-06-23 11:38:05'),(72,4,6,'B8','2020-06-23 11:38:05','2020-06-23 11:38:05'),(73,4,4,'HA1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(74,4,4,'HA2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(75,4,4,'HA3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(76,5,1,'GE1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(77,5,1,'GE2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(78,5,1,'GE3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(79,5,1,'GE4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(80,5,1,'GE5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(81,5,1,'GE6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(82,5,1,'GE7','2020-06-23 11:38:05','2020-06-23 11:38:05'),(83,5,1,'GE8','2020-06-23 11:38:05','2020-06-23 11:38:05'),(84,5,1,'GE9','2020-06-23 11:38:05','2020-06-23 11:38:05'),(85,5,1,'GE10','2020-06-23 11:38:05','2020-06-23 11:38:05'),(86,5,1,'GE11','2020-06-23 11:38:05','2020-06-23 11:38:05'),(87,5,1,'GE12','2020-06-23 11:38:05','2020-06-23 11:38:05'),(88,5,2,'SL1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(89,5,2,'SL2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(90,5,2,'SL3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(91,5,2,'SL4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(92,5,2,'SL5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(93,5,2,'SL6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(94,5,2,'SL7','2020-06-23 11:38:05','2020-06-23 11:38:05'),(95,5,2,'SL8','2020-06-23 11:38:05','2020-06-23 11:38:05'),(96,5,2,'SL9','2020-06-23 11:38:05','2020-06-23 11:38:05'),(97,5,2,'SL10','2020-06-23 11:38:05','2020-06-23 11:38:05'),(98,5,2,'SL11','2020-06-23 11:38:05','2020-06-23 11:38:05'),(99,5,2,'SL12','2020-06-23 11:38:05','2020-06-23 11:38:05'),(100,6,3,'CC1','2020-06-23 11:38:05','2020-06-23 11:38:05'),(101,6,3,'CC2','2020-06-23 11:38:05','2020-06-23 11:38:05'),(102,6,3,'CC3','2020-06-23 11:38:05','2020-06-23 11:38:05'),(103,6,3,'CC4','2020-06-23 11:38:05','2020-06-23 11:38:05'),(104,6,3,'CC5','2020-06-23 11:38:05','2020-06-23 11:38:05'),(105,6,3,'CC6','2020-06-23 11:38:05','2020-06-23 11:38:05'),(106,6,3,'CC7','2020-06-23 11:38:05','2020-06-23 11:38:05'),(107,6,3,'CC8','2020-06-23 11:38:05','2020-06-23 11:38:05'),(108,6,3,'CC9','2020-06-23 11:38:05','2020-06-23 11:38:05'),(109,6,3,'CC10','2020-06-23 11:38:05','2020-06-23 11:38:05'),(110,6,3,'CC11','2020-06-23 11:38:05','2020-06-23 11:38:05'),(111,6,3,'CC12','2020-06-23 11:38:05','2020-06-23 11:38:05'),(112,6,3,'CC13','2020-06-23 11:38:05','2020-06-23 11:38:05'),(113,6,3,'CC14','2020-06-23 11:38:05','2020-06-23 11:38:05'),(114,6,3,'CC15','2020-06-23 11:38:05','2020-06-23 11:38:05'),(115,6,3,'CC16','2020-06-23 11:38:05','2020-06-23 11:38:05'),(116,6,3,'CC17','2020-06-23 11:38:05','2020-06-23 11:38:05'),(117,6,3,'CC18','2020-06-23 11:38:05','2020-06-23 11:38:05'),(118,6,3,'CC19','2020-06-23 11:38:05','2020-06-23 11:38:05'),(119,6,3,'CC20','2020-06-23 11:38:05','2020-06-23 11:38:05'),(120,6,3,'CC21','2020-06-23 11:38:05','2020-06-23 11:38:05'),(121,6,3,'CC22','2020-06-23 11:38:05','2020-06-23 11:38:05'),(122,6,3,'CC23','2020-06-23 11:38:05','2020-06-23 11:38:05'),(123,6,3,'CC24','2020-06-23 11:38:05','2020-06-23 11:38:05'),(124,6,3,'CC25','2020-06-23 11:38:05','2020-06-23 11:38:05');
/*!40000 ALTER TABLE `train_coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `train_details`
--

LOCK TABLES `train_details` WRITE;
/*!40000 ALTER TABLE `train_details` DISABLE KEYS */;
INSERT INTO `train_details` VALUES (1,11001,' train1',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(2,11002,' train2',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(3,21001,' train3',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(4,21003,' train4',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(5,30001,' train5',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(6,12345,' train6',0,'2020-06-23 11:38:05','2020-06-23 11:38:05');
/*!40000 ALTER TABLE `train_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `train_schedule`
--

LOCK TABLES `train_schedule` WRITE;
/*!40000 ALTER TABLE `train_schedule` DISABLE KEYS */;
INSERT INTO `train_schedule` VALUES (1,1,1,0,5,0,'00:00:11','11:15:00',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(2,1,2,1,5,0,'00:00:12','12:15:00',100,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(3,1,3,2,5,0,'00:00:13','13:15:00',200,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(4,1,4,3,5,0,'00:00:14','14:15:00',300,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(5,1,5,4,5,0,'00:00:15','15:15:00',400,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(6,1,6,5,5,0,'00:00:16','16:15:00',500,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(7,1,7,6,6,1,'00:00:01','01:15:00',600,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(8,1,8,7,6,1,'00:00:02','02:15:00',700,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(9,1,9,8,6,1,'00:00:03','03:15:00',800,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(10,1,10,9,6,1,'00:00:04','04:15:00',900,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(11,1,11,10,7,2,'00:00:01','01:15:00',1000,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(12,1,12,11,7,2,'00:00:02','02:15:00',1100,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(13,2,10,0,1,0,'00:00:06','06:15:00',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(14,2,12,1,1,0,'00:00:09','09:15:00',150,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(15,2,13,2,1,0,'00:00:12','12:15:00',300,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(16,2,14,3,1,0,'00:00:15','15:15:00',450,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(17,2,15,4,1,0,'00:00:20','20:15:00',600,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(18,2,16,5,1,0,'00:00:23','23:15:00',750,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(19,2,17,6,2,1,'00:00:04','04:15:00',900,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(20,2,18,7,2,1,'00:00:07','07:15:00',1050,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(21,2,19,8,2,1,'00:00:10','10:15:00',1200,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(22,2,20,9,2,1,'00:00:13','13:15:00',1350,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(23,2,21,10,2,1,'00:00:16','16:15:00',1500,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(24,2,22,11,3,1,'00:00:19','19:15:00',1650,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(25,2,23,12,3,1,'00:00:22','22:15:00',1800,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(26,2,24,13,3,2,'00:00:25','25:15:00',1950,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(27,3,14,0,4,0,'00:00:10','10:15:00',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(28,3,12,1,4,0,'00:00:12','12:15:00',20,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(29,3,10,2,4,0,'00:00:14','14:15:00',40,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(30,3,8,3,4,0,'00:00:16','16:15:00',60,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(31,3,7,4,4,0,'00:00:18','18:15:00',80,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(32,3,6,5,4,0,'00:00:20','20:15:00',100,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(33,3,5,6,4,0,'00:00:22','22:15:00',120,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(34,3,4,7,4,0,'00:00:24','24:15:00',140,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(35,3,3,8,5,1,'00:00:02','02:15:00',160,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(36,3,2,9,5,1,'00:00:04','04:15:00',180,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(37,3,1,10,5,1,'00:00:06','06:15:00',200,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(38,4,20,0,2,0,'00:00:06','06:15:00',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(39,4,16,1,2,0,'00:00:23','23:15:00',30,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(40,4,24,2,3,1,'00:00:18','18:15:00',60,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(41,4,25,3,3,1,'00:00:20','20:15:00',90,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(42,4,1,4,4,2,'00:00:07','07:15:00',120,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(43,4,2,5,4,2,'00:00:09','09:15:00',150,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(44,4,3,6,4,2,'00:00:11','11:15:00',180,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(45,4,4,7,4,2,'00:00:13','13:15:00',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(46,4,5,8,4,2,'00:00:15','15:15:00',50,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(47,4,6,9,4,2,'00:00:17','17:15:00',100,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(48,4,7,10,4,2,'00:00:19','19:15:00',150,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(49,4,8,11,4,2,'00:00:21','21:15:00',200,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(50,4,9,12,4,2,'00:00:23','23:15:00',250,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(51,4,10,13,5,3,'00:00:01','01:15:00',300,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(52,4,11,14,5,3,'00:00:03','03:15:00',350,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(53,5,24,0,3,0,'00:00:23','23:15:00',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(54,5,23,1,4,1,'00:00:01','01:15:00',60,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(55,5,22,2,4,1,'00:00:03','03:15:00',120,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(56,5,21,3,4,1,'00:00:05','05:15:00',180,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(57,5,20,4,4,1,'00:00:07','07:15:00',240,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(58,5,19,5,4,1,'00:00:09','09:15:00',300,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(59,6,1,0,1,0,'00:00:09','09:15:00',0,'2020-06-23 11:38:05','2020-06-23 11:38:05'),(60,6,25,1,4,3,'00:00:22','22:15:00',120,'2020-06-23 11:38:05','2020-06-23 11:38:05');
/*!40000 ALTER TABLE `train_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'given1','user1','password1','user1@gmail.com','900000001','2020-06-23 11:38:05','2020-06-23 11:38:05'),(2,'given2','user2','password2','user2@gmail.com','900000002','2020-06-23 11:38:05','2020-06-23 11:38:05'),(3,'given3','user3','password3','user3@gmail.com','900000003','2020-06-23 11:38:05','2020-06-23 11:38:05'),(4,'given4','user4','password4','user4@gmail.com','900000004','2020-06-23 11:38:05','2020-06-23 11:38:05'),(5,'given5','user5','password5','user5@gmail.com','900000005','2020-06-23 11:38:05','2020-06-23 11:38:05'),(6,'given6','user6','password6','user6@gmail.com','900000006','2020-06-23 11:38:05','2020-06-23 11:38:05'),(7,'given7','user7','password7','user7@gmail.com','900000007','2020-06-23 11:38:05','2020-06-23 11:38:05'),(8,'given8','user8','password8','user8@gmail.com','900000008','2020-06-23 11:38:05','2020-06-23 11:38:05'),(9,'given9','user9','password9','user9@gmail.com','900000009','2020-06-23 11:38:05','2020-06-23 11:38:05');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-23 17:14:08