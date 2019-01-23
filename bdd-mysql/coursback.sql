-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: gestioncours
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Cours`
--

DROP TABLE IF EXISTS `Cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cours` (
  `idc` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) NOT NULL,
  `resume` varchar(200) NOT NULL,
  `competences` varchar(100) NOT NULL,
  PRIMARY KEY (`idc`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cours`
--

LOCK TABLES `Cours` WRITE;
/*!40000 ALTER TABLE `Cours` DISABLE KEYS */;
INSERT INTO `Cours` VALUES (1000,'Français','Cours de français','Maitrise parfaite écrit et oral'),(1001,'Latin','Cours de Latin','Maitrises de base de cette langue morte'),(1002,'Mathématiques','Cours de maths','Maitrise arithmétique avancé'),(1003,'Physique Chimie','Cours de physique chimie','Maitrise physique et chimie organique'),(1004,'Histoire Géographie','Cours d histoire géographie','Compétences en histoire et géographie de l an 0 à nos jours'),(1005,'Anglais','Cours d anglais','Maitrise courante écrit et oral');
/*!40000 ALTER TABLE `Cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Inscription`
--

DROP TABLE IF EXISTS `Inscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Inscription` (
  `ids` int(11) NOT NULL,
  `idsess` int(11) NOT NULL,
  PRIMARY KEY (`ids`,`idsess`),
  KEY `idsess` (`idsess`),
  CONSTRAINT `Inscription_ibfk_1` FOREIGN KEY (`ids`) REFERENCES `Student` (`ids`),
  CONSTRAINT `Inscription_ibfk_2` FOREIGN KEY (`idsess`) REFERENCES `SessionCours` (`idsess`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Inscription`
--

LOCK TABLES `Inscription` WRITE;
/*!40000 ALTER TABLE `Inscription` DISABLE KEYS */;
INSERT INTO `Inscription` VALUES (100,2000),(101,2000),(103,2000),(103,2001),(104,2000);
/*!40000 ALTER TABLE `Inscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ListeSpe`
--

DROP TABLE IF EXISTS `ListeSpe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ListeSpe` (
  `idp` int(11) NOT NULL,
  `idc` int(11) NOT NULL,
  PRIMARY KEY (`idp`,`idc`),
  KEY `idc` (`idc`),
  CONSTRAINT `ListeSpe_ibfk_1` FOREIGN KEY (`idp`) REFERENCES `Prof` (`idp`),
  CONSTRAINT `ListeSpe_ibfk_2` FOREIGN KEY (`idc`) REFERENCES `Cours` (`idc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ListeSpe`
--

LOCK TABLES `ListeSpe` WRITE;
/*!40000 ALTER TABLE `ListeSpe` DISABLE KEYS */;
INSERT INTO `ListeSpe` VALUES (200,1002),(201,1000),(201,1001),(203,1004),(203,1005);
/*!40000 ALTER TABLE `ListeSpe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prof`
--

DROP TABLE IF EXISTS `Prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Prof` (
  `idp` int(11) NOT NULL AUTO_INCREMENT,
  `nomp` varchar(50) NOT NULL,
  `prenomp` varchar(50) NOT NULL,
  PRIMARY KEY (`idp`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prof`
--

LOCK TABLES `Prof` WRITE;
/*!40000 ALTER TABLE `Prof` DISABLE KEYS */;
INSERT INTO `Prof` VALUES (200,'Reveu','Jean'),(201,'Proviste','Alain'),(202,'Dupont','Marcel'),(203,'Durant','Roger');
/*!40000 ALTER TABLE `Prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SessionCours`
--

DROP TABLE IF EXISTS `SessionCours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SessionCours` (
  `idsess` int(11) NOT NULL AUTO_INCREMENT,
  `idc` int(11) DEFAULT NULL,
  `idp` int(11) DEFAULT NULL,
  `datedeb` date NOT NULL,
  `semaines` int(11) DEFAULT NULL,
  PRIMARY KEY (`idsess`),
  KEY `idc` (`idc`),
  KEY `idp` (`idp`),
  CONSTRAINT `SessionCours_ibfk_1` FOREIGN KEY (`idc`) REFERENCES `Cours` (`idc`),
  CONSTRAINT `SessionCours_ibfk_2` FOREIGN KEY (`idp`) REFERENCES `Prof` (`idp`)
) ENGINE=InnoDB AUTO_INCREMENT=2004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SessionCours`
--

LOCK TABLES `SessionCours` WRITE;
/*!40000 ALTER TABLE `SessionCours` DISABLE KEYS */;
INSERT INTO `SessionCours` VALUES (2000,1002,200,'2019-01-01',10),(2001,1004,203,'2019-02-02',12),(2002,1001,201,'2019-02-01',6),(2003,1002,201,'2019-05-01',10);
/*!40000 ALTER TABLE `SessionCours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `ids` int(11) NOT NULL AUTO_INCREMENT,
  `noms` varchar(50) NOT NULL,
  `prenoms` varchar(50) NOT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (100,'Carrey','Romain'),(101,'Pichon','Robert'),(102,'Rimbal','Arthur'),(103,'Marcheurduciel','Luke'),(104,'Vador','Sombre');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23 16:02:31
