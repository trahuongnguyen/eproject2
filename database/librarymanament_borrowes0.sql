-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: librarymanament
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `borrowes`
--

DROP TABLE IF EXISTS `borrowes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrowes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` int DEFAULT NULL,
  `card_member_id` int DEFAULT NULL,
  `librarian_id` int DEFAULT NULL,
  `borrow_from_date` date DEFAULT NULL,
  `borrow_to_date` date DEFAULT NULL,
  `actual_returned_date` date DEFAULT NULL,
  `other_note` varchar(350) DEFAULT NULL,
  `late_fee` float DEFAULT NULL,
  `borrow_fee` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  KEY `card_member_id` (`card_member_id`),
  KEY `librarian_id` (`librarian_id`),
  CONSTRAINT `borrowes_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `borrowes_ibfk_2` FOREIGN KEY (`card_member_id`) REFERENCES `card_members` (`id`),
  CONSTRAINT `borrowes_ibfk_3` FOREIGN KEY (`librarian_id`) REFERENCES `librarians` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowes`
--

LOCK TABLES `borrowes` WRITE;
/*!40000 ALTER TABLE `borrowes` DISABLE KEYS */;
INSERT INTO `borrowes` VALUES (1,1,1,1,'2023-09-07','2023-11-01','2023-12-01','không làm hỏng sách',20000,30000,50000),(2,2,1,1,'2023-09-07','2023-12-05','2024-01-01','Trả đúng hạn',20000,40000,60000),(3,26,1,1,'2023-09-01','2023-09-15','2023-09-07','Làm mất sách',20000,10000,30000);
/*!40000 ALTER TABLE `borrowes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-10  7:46:19
