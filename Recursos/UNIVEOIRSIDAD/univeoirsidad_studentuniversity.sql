-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: univeoirsidad
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `studentuniversity`
--

DROP TABLE IF EXISTS `studentuniversity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentuniversity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `faculty` varchar(100) NOT NULL,
  `idUser` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `F_studentUniversity` (`idUser`),
  CONSTRAINT `F_studentUniversity` FOREIGN KEY (`idUser`) REFERENCES `useruniversity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentuniversity`
--

LOCK TABLES `studentuniversity` WRITE;
/*!40000 ALTER TABLE `studentuniversity` DISABLE KEYS */;
INSERT INTO `studentuniversity` VALUES (1,'Diseño',1),(2,'Telecomunicaciones',NULL),(3,'Economia',NULL),(4,'Diseño',4),(5,'Informatica',8),(6,'Diseño',9),(7,'Diseño',10),(10,'Diseño',9),(11,'Diseño',9),(12,'Diseño',9),(13,'Diseño',9),(14,'Diseño',9),(15,'Diseño',9),(16,'Diseño',9),(17,'Diseño',9),(18,'Diseño',9),(19,'Diseño',9),(20,'Diseño',9),(21,'Diseño',9);
/*!40000 ALTER TABLE `studentuniversity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-20 19:10:49
