-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: librarymanament
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `publishers`
--

DROP TABLE IF EXISTS `publishers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publishers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishers`
--

LOCK TABLES `publishers` WRITE;
/*!40000 ALTER TABLE `publishers` DISABLE KEYS */;
INSERT INTO `publishers` VALUES (1,'BPB Publications'),(2,'Random House'),(3,'Harper & Row'),(4,'Ace Books'),(5,'Nhà Xuất Bản Văn Học'),(6,'Olympia Press'),(7,'Hogarth Press'),(8,'Tor book'),(9,'Alfred A. Knopf, Inc'),(10,'Farrar, Straus and Giroux'),(11,'Viking Adult'),(12,'Heinemann'),(13,'Scholastic'),(14,'Norstedts Förlag'),(15,'Microsoft Press'),(16,'Doubleday'),(17,'April 10'),(18,'September 7'),(19,'‎India Penguin'),(20,'Mulholland Books'),(21,'Sudamericana'),(22,'Addison-Wesley'),(23,'Back Bay Books, Little, Brown'),(24,'Bantam Books'),(25,'Beacon Press'),(26,'Benjamin W. Huebsch '),(27,'Bloomsbury'),(28,'Broadway Books'),(29,'Caravaggio'),(30,'Celadon Books'),(31,'Chapman & Hall'),(32,'Chatto & Windus'),(33,'Chilton Books'),(34,'Chongqing Press'),(35,'Collins Crime Club'),(36,'Constable & Robinson Ltd'),(37,'Coward, McCann and Geoghegan'),(38,'Crown Publishing Group'),(39,'Diversified Publishing'),(40,'Edward Arnold'),(41,'Faber'),(42,'Galileo Publishers'),(43,'Fourth Estate (UK)'),(44,'Francisco de Robles'),(45,'Geoffrey Bles'),(46,'George Newnes Ltd'),(47,'Grand Central Publishing'),(48,'Harcourt Brace Jovanovich'),(49,'HarperCollins Publishers'),(50,'Henry Holt and Company'),(51,'Houghton Mifflin'),(52,'J. B. Lippincott & Co.'),(53,'Jonathan Cape'),(54,'Kadokawa Shoten'),(55,'Knopf'),(56,'Lackington'),(57,'Literature Publishing House'),(58,'Little, Brown and Company'),(59,'MacGibbon & Kee'),(60,'Macmillan'),(61,'New Riders'),(62,'New York: Holt, Rinehart & Winston'),(63,'No Starch Press'),(64,'O\'Reilly Media'),(65,'Orion (UK)'),(66,'Oxford University Press'),(67,'Pan Books'),(68,'Pan Macmillan'),(69,'Pearson Education'),(70,'Penguin Publishing'),(71,'Penguin Random House'),(72,'Picador'),(73,'Prentice Hall'),(74,'Riverhead Books'),(75,'Roberts Brothers'),(76,'Scribner'),(77,'Secker & Warburg'),(78,'Shakespeare and Company'),(79,'Simon & Schuster'),(80,'Smith, Elder & Co'),(81,'St Martin\'s Griffin'),(82,'St. Martin\'s Press'),(83,'St. Martin\'s Publishing Group'),(84,'T. Egerton, Whitehall'),(85,'Tân Dân'),(86,'Tata McGraw-Hill'),(87,'The Dial Press'),(88,'The New Press'),(89,'The Penguin Press'),(90,'The Russian Messenger'),(91,'Viking Press '),(92,'Victor Gollancz Ltd'),(93,'Villard Books'),(94,'Vintage Publishing'),(95,'W. W. Norton'),(96,'W. W. Norton & Company'),(97,'William Blackwood and Sons'),(98,'William Heinemann Ltd'),(99,'writers association'),(100,'YMCA Press');
/*!40000 ALTER TABLE `publishers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-07 10:16:31
