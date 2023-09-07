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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Aldous Huxley'),(2,'Adam Kay'),(3,'Agatha Christie'),(4,'Alan Bradley'),(6,'Alex Michaelides'),(7,'Alice Walker'),(8,'Andy Weir'),(9,'Anthony Bourdain'),(10,'Anthony Doerr'),(11,'Arthur Conan Doyle'),(12,'Attica Locke'),(13,'Betty Friedan'),(14,'Bill Bryson'),(15,'Bob Woodward, Carl Bernstein'),(16,'Bonnie Garmus'),(17,'Bram Stoker'),(18,'Brendan Slocumb'),(19,'C. S. Lewis'),(20,'Casey McQuiston'),(21,'Charles Dickens'),(22,'Charlotte Brontë'),(23,'Cheryl Strayed'),(24,'Chinua Achebe'),(25,'Chris Miller'),(26,'Christina Lauren'),(27,'Christopher Clark'),(28,'Colson Whitehead'),(29,'Cormac McCarthy'),(30,'Dan Brown'),(31,'Daphne du Maurier'),(32,'Dave Thomas'),(33,'David Griffiths'),(34,'David M. Geary'),(35,'Dee Brown'),(36,'Donald Knuth'),(37,'Douglas Adams'),(38,'E. Balagurusamy'),(39,'E. M. Forster'),(40,'Elie Wiesel'),(41,'Elizabeth Gilbert'),(42,'Elizabeth Kolbert'),(43,'Emily Brontë'),(44,'F. Scott Fitzgerald'),(45,'Frank Herbert'),(46,'Frank McCourt'),(47,'Frankenstein'),(48,'Fyodor Mikhaylovich Dostoyevsky'),(49,'Gabriel García Márquez'),(50,'Gabrielle Zevin'),(51,'George Eliot'),(52,'George Orwell'),(53,'Gillian Flynn'),(54,'Gillian McAllister'),(55,'Glennon Doyle'),(56,'Hanya Yanagihara'),(57,'Harper Lee'),(58,'Hernan Diaz'),(59,'Hilary Mantel'),(60,'Suzanne Collins'),(61,'Hồ Chí Minh'),(62,'Ian McEwan'),(63,'Isabel Wilkerson'),(64,'J. D. Salinger'),(66,'Jack London'),(67,'James Baldwin'),(68,'James Joyce'),(69,'Jane Casey'),(70,'Jane Austen'),(71,'Jane Robins'),(72,'Jeannette Walls'),(73,'Jennette McCurdy'),(74,'Jennifer Egan'),(75,'Jesmyn Ward'),(76,'John Berendt'),(77,'John Hersey'),(78,'John Steinbeck'),(79,'Jon Bentley'),(80,'Jon Krakauer'),(81,'Joseph Heller'),(82,'Joshua Bloch'),(83,'Kara Gnodde'),(84,'Ken Follett'),(85,'Kent Beck'),(86,'Khaled Hosseini'),(87,'Koji Suzuki'),(88,'Kristin Hannah'),(89,'Kyle Mills'),(90,'Lê Lựu'),(92,'Lev Nikolayevich Tolstoy'),(93,'Liane Moriarty'),(94,'Lisa Jewell'),(95,'Liu Cixin'),(96,'Louisa May Alcott'),(97,'Lucy Foley'),(98,'Malcolm Gladwell'),(99,'Margaret Atwood'),(100,'Margaret Mitchell'),(101,'Marijn Haverbeke'),(102,'Mark Lutz'),(103,'Mark Mitchell'),(104,'Mark Twain'),(105,'Mary Roach'),(106,'Mary Shelley'),(107,'Michael Pollan'),(108,'Michelle Alexander'),(109,'Michelle Hoffman'),(110,'Michelle Obama'),(111,'Miguel de Cervantes'),(112,'Mikhail Afanasievich Bulgakov'),(113,'Min Jin Lee'),(114,'Nam Cao'),(115,'Natalie Haynes'),(116,'Nguyễn Du'),(118,'Nguyên Hồng'),(119,'Nguyễn Tuân'),(120,'Octavia E. Butler'),(121,'Oliver Sacks'),(122,'Oyinkan Braithwaite'),(123,'Paul Kalanithi'),(124,'Paulo Coelho'),(125,'Peter Straub'),(126,'Philip K. Dick'),(127,'Phùng Quán'),(128,'R.J. Palacio'),(129,'Rachel Carson'),(130,'Rachel Cusk'),(131,'Ralph Ellison'),(132,'Ray Bradbury'),(133,'Raymond Chandler'),(134,'Rebecca Skloot'),(135,'Richard Rhodes'),(136,'Robert Cecil Martin'),(137,'Robert McCrum'),(138,'Sally Rooney'),(139,'Salman Rushdie'),(140,'Sarah Pekkanen'),(141,'Saul Friedländer'),(142,'Shari Lapena'),(143,'Shirley Jackson'),(144,'Siddhartha Mukherjee'),(145,'Stacy Willingham'),(146,'Stephen King'),(147,'Steve McConnell'),(148,'Stieg Larsson'),(149,'Sylvia Plath'),(150,'Tana French'),(151,'Tara Westover'),(152,'Ngô Tất Tố'),(153,'Taylor Jenkins Reid'),(154,'Tô Hoài'),(155,'Tom Wolfe'),(156,'Toni Morrison'),(157,'Truman Capote'),(158,'Ursula K. Le Guin'),(159,'V. E. Schwab'),(160,'Virginia Woolf'),(161,'Vladimir Vladimirovich Nabokov'),(162,'Vu Trong Phung'),(163,'William Gibson'),(164,'William Peter Blatty'),(165,'Yaa Gyasi'),(166,'Yashavant Kanetkar');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
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
