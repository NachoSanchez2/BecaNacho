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
-- Table structure for table `useruniversity`
--

DROP TABLE IF EXISTS `useruniversity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `useruniversity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `mail` varchar(200) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `tipoPersona` int NOT NULL,
  PRIMARY KEY (`id`,`dni`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useruniversity`
--

LOCK TABLES `useruniversity` WRITE;
/*!40000 ALTER TABLE `useruniversity` DISABLE KEYS */;
INSERT INTO `useruniversity` VALUES (1,'hola','pepe','hola','hola','pepe','hola',1),(2,'hola','maria','hola','hola','maria','hola',2),(3,'pablo','pablo','pablo','pablo','pablo','pablo',2),(4,'paco','paco','paco','paco','paco','paco',1),(5,'esteban','esteban','esteban','esteban','esteban','esteban',3),(6,'lucas','lucas','lucas','lucas','lucas','lucas',3),(7,'pato','pato','pato','pato','pato','pato',2),(8,'ocho','ocho','ocho','ocho','ocho','ocho',1),(9,'test','test','test12345','test@gmail.com','test','test',1),(10,'test','test','test12345','test@gmail.com','test','test',1),(11,'test','test','test12345','test@gmail.com','test','test',1),(12,'test','test','test12345','test@gmail.com','test','test',1),(13,'test','test','test12345','test@gmail.com','test','test',1),(14,'test','test','test12345','test@gmail.com','test','test',1),(15,'test','test','test12345','test@gmail.com','test','test',1),(16,'test','test','test12345','test@gmail.com','test','test',1),(17,'test','test','test12345','test@gmail.com','test','test',1),(18,'test','test','test12345','test@gmail.com','test','test',2),(19,'test','test','test12345','test@gmail.com','test','test',3),(20,'test','test','test12345','test@gmail.com','test','test',1),(21,'test','test','test12345','test@gmail.com','test','test',2),(22,'test','test','test12345','test@gmail.com','test','test',3),(23,'test','test','test12345','test@gmail.com','test','test',1),(24,'test','test','test12345','test@gmail.com','test','test',2),(25,'test','test','test12345','test@gmail.com','test','test',3),(26,'test','test','test12345','test@gmail.com','test','test',1),(27,'test','test','test12345','test@gmail.com','test','test',2),(28,'test','test','test12345','test@gmail.com','test','test',3),(29,'test','test','test12345','test@gmail.com','test','test',1),(30,'test','test','test12345','test@gmail.com','test','test',2),(31,'test','test','test12345','test@gmail.com','test','test',3),(32,'test','test','test12345','test@gmail.com','test','test',1),(33,'test','test','test12345','test@gmail.com','test','test',2),(34,'test','test','test12345','test@gmail.com','test','test',3),(35,'test','test','test12345','test@gmail.com','test','test',1),(36,'test','test','test12345','test@gmail.com','test','test',2),(37,'test','test','test12345','test@gmail.com','test','test',3),(38,'test','test','test12345','test@gmail.com','test','test',1),(39,'test','test','test12345','test@gmail.com','test','test',2),(40,'test','test','test12345','test@gmail.com','test','test',3),(41,'test','test','test12345','test@gmail.com','test','test',1),(42,'test','test','test12345','test@gmail.com','test','test',2),(43,'test','test','test12345','test@gmail.com','test','test',3),(44,'test','test','test12345','test@gmail.com','test','test',1),(45,'test','test','test12345','test@gmail.com','test','test',2),(46,'test','test','test12345','test@gmail.com','test','test',3);
/*!40000 ALTER TABLE `useruniversity` ENABLE KEYS */;
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
