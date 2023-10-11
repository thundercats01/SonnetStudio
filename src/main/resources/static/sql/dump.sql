-- MySQL dump 10.13  Distrib 8.0.33, for macos13.3 (arm64)
--
-- Host: localhost    Database: sonnetStudio_db
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `badges`
--

DROP TABLE IF EXISTS `badges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `badges` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `badges`
--

LOCK TABLES `badges` WRITE;
/*!40000 ALTER TABLE `badges` DISABLE KEYS */;
INSERT INTO `badges` VALUES (1,'Default badge','Default','/capstone_IMGs/badges/badge-default.png'),(2,'Apple badge','Apple','/capstone_IMGs/badges/badge-apple.jpeg'),(3,'Einstein badge','Einstein','/capstone_IMGs/badges/badge-einstein.jpeg'),(4,'Pearl badge','Pearl','/capstone_IMGs/badges/badge-pearl.avif'),(5,'Joan badge','Joan','/capstone_IMGs/badges/badge-joan.jpeg');
/*!40000 ALTER TABLE `badges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` text,
  `user_id` bigint DEFAULT NULL,
  `verse_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  KEY `FK3f3dty25lqmo30se1si2vvbsh` (`verse_id`),
  CONSTRAINT `FK3f3dty25lqmo30se1si2vvbsh` FOREIGN KEY (`verse_id`) REFERENCES `verses` (`id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'This is wonderful!',1,1),(2,'Amazing!',2,2),(3,'I resonate with this.',3,12),(4,'Well written!',1,2),(5,'I love the imagery.',2,3),(6,'Keep up the good work!',3,1),(7,'Incredible!',1,11),(8,'This speaks to my soul.',2,12),(9,'Beautifully expressed.',3,2),(10,'I can feel the emotion.',1,3),(11,'Your words paint a vivid picture.',4,4),(12,'I feel the nostalgia in every line.',5,5),(13,'This is pure artistry.',6,6),(14,'Your creativity knows no bounds.',7,7),(15,'A beautiful expression of eternal love.',3,8),(16,'I can almost hear the laughter in your words.',4,11),(17,'Your words touch the heart.',1,10),(18,'Incredible imagery!',4,5),(19,'You have a gift for storytelling.',5,6),(20,'This verse speaks volumes.',6,7),(21,'I\'m inspired by your words.',7,8),(22,'A masterpiece of emotions.',2,9),(23,'This is poetry in its purest form.',6,10),(24,'Your verses light up the page.',1,1),(25,'I can feel the passion in your words.',6,4),(26,'Your verse carries a sense of mystery.',3,5),(27,'This is a journey through ink and paper.',3,6),(28,'A beautiful tribute to nature\'s stories.',4,7),(29,'Your words are a balm for the soul.',5,8),(30,'A symphony of joy indeed!',6,9),(31,'Your verse is a source of inspiration.',7,10);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `followers`
--

DROP TABLE IF EXISTS `followers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `followers` (
  `followers_user_id` bigint NOT NULL,
  `following_user_id` bigint NOT NULL,
  KEY `FK3i7bkpiwlsh1ubr4al9338ojt` (`following_user_id`),
  KEY `FKsp9pjek5mgmellobjkapl73y8` (`followers_user_id`),
  CONSTRAINT `FK3i7bkpiwlsh1ubr4al9338ojt` FOREIGN KEY (`following_user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKsp9pjek5mgmellobjkapl73y8` FOREIGN KEY (`followers_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `followers`
--

LOCK TABLES `followers` WRITE;
/*!40000 ALTER TABLE `followers` DISABLE KEYS */;
INSERT INTO `followers` VALUES (1,2),(2,3),(3,1),(4,2),(5,1),(6,3),(2,4),(3,4),(4,5),(5,6),(6,5),(1,4),(2,5),(3,6),(4,6),(5,2),(6,1),(1,3),(2,6),(3,5),(7,1),(7,2),(7,3),(7,4),(7,5),(7,6),(1,7),(2,7),(3,7),(4,7),(5,7),(6,7);
/*!40000 ALTER TABLE `followers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `verse_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnvx9seeqqyy71bij291pwiwrg` (`user_id`),
  KEY `FKl05svhwymjdh4scv2lhtf0flj` (`verse_id`),
  CONSTRAINT `FKl05svhwymjdh4scv2lhtf0flj` FOREIGN KEY (`verse_id`) REFERENCES `verses` (`id`),
  CONSTRAINT `FKnvx9seeqqyy71bij291pwiwrg` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,1,2),(2,2,3),(3,3,1),(4,1,3),(5,2,1),(6,3,2),(7,1,3),(8,2,1),(9,3,2),(10,1,3),(11,4,2),(12,5,3),(13,6,1),(14,2,4),(15,3,5),(16,4,6),(17,5,7),(18,6,8),(19,7,9),(20,3,10),(21,7,1),(22,6,2),(23,4,3),(24,5,4),(25,6,5),(26,4,6),(27,3,7),(28,2,8),(29,1,9);
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_badges`
--

DROP TABLE IF EXISTS `user_badges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_badges` (
  `user_id` bigint NOT NULL,
  `badges_id` bigint NOT NULL,
  KEY `FK337cc9ux9pqlb991y6w43to3j` (`badges_id`),
  KEY `FKr46ah81sjymsn035m4ojstn5s` (`user_id`),
  CONSTRAINT `FK337cc9ux9pqlb991y6w43to3j` FOREIGN KEY (`badges_id`) REFERENCES `badges` (`id`),
  CONSTRAINT `FKr46ah81sjymsn035m4ojstn5s` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_badges`
--

LOCK TABLES `user_badges` WRITE;
/*!40000 ALTER TABLE `user_badges` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_badges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bio` varchar(255) DEFAULT NULL,
  `current_badge` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Passionate about expressing through words.','/capstone_IMGs/badges/badge-default.png','poetrylover@example.com','$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi','PoetryLover123'),(2,'Exploring the depths of creativity.','/capstone_IMGs/badges/badge-apple.jpeg','creative@example.com','$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi','CreativeSoul89'),(3,'Seeking inspiration in every word.','/capstone_IMGs/badges/badge-einstein.jpeg','writer@example.com','$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi','InspiredWriter55'),(4,'Admiring the world through verse.','/capstone_IMGs/badges/badge-joan.jpeg','graceful@example.com','$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi','GracefulGazer'),(5,'Finding tranquility in writing.','/capstone_IMGs/badges/badge-pearl.avif','serene@example.com','$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi','SereneScribe'),(6,'Weaving dreams with words.','/capstone_IMGs/badges/badge-joan.jpeg','dreamweaver@example.com','$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi','DreamWeaver123'),(7,'Singing through verses.','/capstone_IMGs/badges/badge-pearl.avif','soulful@example.com','$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi','SoulfulSinger');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verses`
--

DROP TABLE IF EXISTS `verses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` text,
  `genre` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK805olp0ojtdq1u08jabhpf9ax` (`user_id`),
  CONSTRAINT `FK805olp0ojtdq1u08jabhpf9ax` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verses`
--

LOCK TABLES `verses` WRITE;
/*!40000 ALTER TABLE `verses` DISABLE KEYS */;
INSERT INTO `verses` VALUES (1,'In the quiet moments before dawn, the world holds its breath, awaiting the first light of day. It is in this hushed stillness that my thoughts find their voice, and my heart speaks its truth. The world awakens, and so do I, with pen in hand and soul laid bare.','Reflective',4),(2,'Beneath the ancient oak tree, where whispers of the past linger in the breeze, I find solace. Each rustling leaf, a page in nature\'s book, tells a story of time gone by. Here, I pen my own tales, a tribute to the tales that came before.','Nostalgic',5),(3,'Beneath the starry night, I find my solace.','Romantic',1),(4,'In the hustle and bustle, silence speaks.','Reflective',2),(5,'A dance of colors in the morning sky.','Nature',3),(6,'Whispers of the wind carry secrets untold. In their gentle embrace, I find sanctuary, a place where my words can roam free.','Mysterious',4),(7,'Lost in a world of ink and paper, I dance upon the blank canvas, letting my thoughts flow like a river, winding and weaving through the pages.','Creative',5),(8,'Footprints in the sand, memories left behind. Each step a story, each grain of sand a witness to the journey.','Nostalgic',6),(9,'Eternal love, a flame that never fades. It burns bright in the darkest night, a beacon of hope for weary hearts.','Romantic',7),(10,'Echoes of laughter in the autumn breeze, a symphony of joy that resonates through the golden leaves. In this moment, I find pure bliss.','Joyful',5),(11,'Silent tears, stories only the heart knows. They speak of battles fought and victories won, of strength and resilience in the face of adversity.','Reflective',3),(12,'Underneath the city lights, dreams take flight. In the midst of chaos, I find my sanctuary, where imagination knows no bounds.','Inspiring',7);
/*!40000 ALTER TABLE `verses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-11 15:48:37
