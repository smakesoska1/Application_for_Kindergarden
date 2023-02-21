CREATE DATABASE  IF NOT EXISTS `freedb_RPRbaza2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `freedb_RPRbaza2`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: sql.freedb.tech    Database: freedb_RPRbaza2
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `id_activity` int NOT NULL,
  `activity_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_activity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'Igranje'),(2,'spavanje'),(3,'igra u dvoristu'),(4,'sportska igra'),(5,'ucenje njemckog'),(7,'plivanje'),(8,'nogomet'),(9,'ples'),(10,'rukomet'),(13,'rucak'),(14,'dorucak'),(15,'no activity up until now');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `child`
--

DROP TABLE IF EXISTS `child`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `child` (
  `id_child` int NOT NULL,
  `child_name` varchar(45) NOT NULL,
  `child_surname` varchar(45) NOT NULL,
  `child_adress` varchar(45) NOT NULL,
  `parent_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `activity_id` int DEFAULT NULL,
  `child_notes_id` int DEFAULT NULL,
  PRIMARY KEY (`id_child`),
  KEY `fk_child_parent_idx` (`parent_id`),
  KEY `fk_child_teacher_idx` (`teacher_id`),
  KEY `fx_child_activity_idx` (`activity_id`),
  KEY `FK_child_notes_idx` (`child_notes_id`),
  CONSTRAINT `fk_child_notes` FOREIGN KEY (`child_notes_id`) REFERENCES `child_notes` (`id_note`),
  CONSTRAINT `fk_child_parent` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`id_parent`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_child_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id_teacher`),
  CONSTRAINT `fx_child_activity` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id_activity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `child`
--

LOCK TABLES `child` WRITE;
/*!40000 ALTER TABLE `child` DISABLE KEYS */;
INSERT INTO `child` VALUES (1,'Lejna','Mujic','Novopazarska',1,1,'08:00:00','17:00:00',9,1),(2,'Nidal','Halic','Geteova',2,2,'10:00:00','18:00:00',4,3),(3,'Sara','Mujic','Novopazarska',1,1,'08:00:00','17:00:00',8,2),(4,'Ajdin','Halilovic','Novopazarska',4,3,'09:00:00','16:00:00',10,4),(5,'Nea','Mulic','Branioci 25',3,3,'08:00:00','16:00:00',1,2);
/*!40000 ALTER TABLE `child` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `child_notes`
--

DROP TABLE IF EXISTS `child_notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `child_notes` (
  `id_note` int NOT NULL,
  `note_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_note`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `child_notes`
--

LOCK TABLES `child_notes` WRITE;
/*!40000 ALTER TABLE `child_notes` DISABLE KEYS */;
INSERT INTO `child_notes` VALUES (1,'Zainteresiran/na'),(2,'Nezainteresiran/na'),(3,'Losa koncentracija'),(4,'Dobra koncentracija'),(5,'Volja za ucenjem'),(6,'Radoznao/la'),(7,'no notes up until now');
/*!40000 ALTER TABLE `child_notes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director` (
  `id_director` int NOT NULL,
  `director_name` varchar(45) NOT NULL,
  `director_surname` varchar(45) NOT NULL,
  `director_adress` varchar(45) NOT NULL,
  `director_username` varchar(45) NOT NULL,
  `director_password` varchar(45) NOT NULL,
  `director_phone` int NOT NULL,
  PRIMARY KEY (`id_director`),
  UNIQUE KEY `DirectorUsername_UNIQUE` (`director_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` VALUES (1,'Nidal','Lalic','Maglajska','nlalic1','password',5230267);
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parent` (
  `id_parent` int NOT NULL,
  `parent_name` varchar(45) NOT NULL,
  `parent_surname` varchar(45) NOT NULL,
  `parent_adress` varchar(45) NOT NULL,
  `parent_username` varchar(45) NOT NULL,
  `parent_password` varchar(45) NOT NULL,
  `parent_phone` int NOT NULL,
  PRIMARY KEY (`id_parent`),
  UNIQUE KEY `ParentUsername_UNIQUE` (`parent_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
INSERT INTO `parent` VALUES (1,'Fatima','Mujic','Novopazarska','fmujic','fmujic',62456726),(2,'Aziz','Halic','Geteova','ahalic','ahalic',63598745),(3,'Najla','Mulic','Trg branilac','nmuhic','nmuhic',61589467),(4,'Sanela','Halilovic','Novopazarska','shalilovic','shalilovic',6589567);
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id_teacher` int NOT NULL,
  `teacher_name` varchar(45) NOT NULL,
  `teacher_surname` varchar(45) NOT NULL,
  `teacher_adress` varchar(45) NOT NULL,
  `teacher_username` varchar(45) NOT NULL,
  `teacher_password` varchar(45) NOT NULL,
  `start_work` time DEFAULT NULL,
  `end_work` time DEFAULT NULL,
  PRIMARY KEY (`id_teacher`),
  UNIQUE KEY `TeacherUsername_UNIQUE` (`teacher_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Amina','Halilovic','adresa123','teacher1','teacher1','07:00:00','20:00:00'),(2,'Zana','Zanic','Mejtas','teacher2','teacher2','09:00:00','18:00:00'),(3,'Nizama','Hodzic','Trg solidarnosti','teacher3','teacher3','09:00:00','17:00:00');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-21 15:11:25
