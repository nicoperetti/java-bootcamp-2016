-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: highschool
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id_course` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `assigned_teacher` int(11) NOT NULL,
  `hours_by_week` int(11) NOT NULL,
  PRIMARY KEY (`id_course`),
  KEY `assigned_teacher` (`assigned_teacher`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`assigned_teacher`) REFERENCES `teacher` (`id_teacher`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'math',1,1),(2,'art',2,4),(3,'biology',3,7);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_time`
--

DROP TABLE IF EXISTS `schedule_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_time` (
  `id_course` int(11) NOT NULL,
  `day` varchar(30) NOT NULL,
  `hour_begin` int(11) NOT NULL,
  `hour_end` int(11) NOT NULL,
  KEY `id_course` (`id_course`),
  CONSTRAINT `schedule_time_ibfk_1` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_time`
--

LOCK TABLES `schedule_time` WRITE;
/*!40000 ALTER TABLE `schedule_time` DISABLE KEYS */;
INSERT INTO `schedule_time` VALUES (1,'monday',9,10),(2,'monday',9,11),(2,'wednesday',9,11),(3,'monday',14,16),(3,'wednesday',14,16),(3,'friday',14,17);
/*!40000 ALTER TABLE `schedule_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `register_number` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `date_of_birth` varchar(30) NOT NULL,
  PRIMARY KEY (`register_number`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'nico1','peretti1','16/12/2000'),(2,'nico2','peretti2','16/12/2001'),(3,'nico3','peretti3','16/12/2002'),(4,'nico4','peretti4','16/12/2003'),(5,'nico5','peretti5','16/12/2004'),(6,'nico6','peretti6','16/12/2005'),(7,'nico7','peretti7','16/12/2006'),(8,'nico8','peretti8','16/12/2007'),(9,'nico9','peretti9','16/12/2008'),(10,'nico10','peretti10','16/12/2009'),(11,'nico11','peretti11','16/12/2000'),(12,'nico12','peretti12','16/12/2001'),(13,'nico13','peretti13','16/12/2002'),(14,'nico14','peretti14','16/12/2003'),(15,'nico15','peretti15','16/12/2004'),(16,'nico16','peretti16','16/12/2005'),(17,'nico17','peretti17','16/12/2006'),(18,'nico18','peretti18','16/12/2007'),(19,'nico19','peretti19','16/12/2008'),(20,'nico20','peretti20','16/12/2009'),(21,'nico21','peretti21','16/12/2000'),(22,'nico22','peretti22','16/12/2001'),(23,'nico23','peretti23','16/12/2002'),(24,'nico24','peretti24','16/12/2003'),(25,'nico25','peretti25','16/12/2004'),(26,'nico26','peretti26','16/12/2005'),(27,'nico27','peretti27','16/12/2006'),(28,'nico28','peretti28','16/12/2007'),(29,'nico29','peretti29','16/12/2008'),(30,'nico30','peretti30','16/12/2009');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_course` (
  `id_course` int(11) NOT NULL,
  `id_student` int(11) NOT NULL,
  `first_partial` int(11) NOT NULL,
  `second_partial` int(11) NOT NULL,
  `final` int(11) NOT NULL,
  KEY `id_course` (`id_course`),
  KEY `id_student` (`id_student`),
  CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`),
  CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`id_student`) REFERENCES `student` (`register_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` VALUES (1,1,10,8,10),(1,2,8,3,10),(1,3,2,2,5),(1,4,10,8,2),(1,5,10,7,1),(1,6,4,10,1),(1,7,6,9,2),(1,8,5,1,4),(1,9,6,7,3),(1,10,3,3,10),(2,11,8,10,3),(2,12,3,8,8),(2,13,3,2,4),(2,14,3,9,1),(2,15,2,7,7),(2,16,7,9,10),(2,17,4,3,4),(2,18,7,5,1),(2,19,3,3,9),(2,20,5,7,8),(3,21,7,1,8),(3,22,9,6,9),(3,23,10,3,5),(3,24,4,8,4),(3,25,4,10,7),(3,26,4,8,5),(3,27,1,5,7),(3,28,1,6,2),(3,29,9,5,1),(3,30,7,8,8);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id_teacher` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `date_of_birth` varchar(30) NOT NULL,
  PRIMARY KEY (`id_teacher`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Mariel','Perez','13/06/1980'),(2,'Ana','Garcia','13/06/1981'),(3,'Roberto','Gonzales','13/06/1982');
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

-- Dump completed on 2016-01-25  0:05:00
