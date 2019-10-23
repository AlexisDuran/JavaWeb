-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 148.234.36.88    Database: dbcursocsi
-- ------------------------------------------------------
-- Server version	5.0.83-community-nt

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `maestro`
--

DROP TABLE IF EXISTS `maestro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maestro` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `no_empleado` int(11) NOT NULL,
  `tipoEmpleadoId` int(11) default NULL,
  `estatus` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `maestro_ibfk_1` (`tipoEmpleadoId`),
  CONSTRAINT `maestro_ibfk_1` FOREIGN KEY (`tipoEmpleadoId`) REFERENCES `tipoempleado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maestro`
--

LOCK TABLES `maestro` WRITE;
/*!40000 ALTER TABLE `maestro` DISABLE KEYS */;
INSERT INTO `maestro` VALUES (2,'Pablo','Pablito','Terceras',420,1,1),(4,'Solis','sol4','password',2,1,1),(5,'Prueba','Pruebaa','1234gg',5,NULL,1),(8,'Adrian','ad97','pwd',1,2,1),(31,'Saul ','Sa58','3369',8,NULL,1),(32,'Maestro','Maestrox','maestro',10,NULL,1),(35,'Test02','Test02','imasecondtest',18,1,1),(36,'Luis','Luis1','null',6,1,0),(37,'Romeo','romsg','romeo123',862,1,1),(38,'Test','Test010','123456',2532,1,1),(39,'andres','alt09','245asd',1,1,1),(40,'asdasd','asdasd<','dasda<<<',12,NULL,1),(41,'Maestro','Maestro','Maestro',36,NULL,1),(43,'Belem','Bema','Bema12',13456,1,1),(44,'Gerardo Mata','ggmr','jaeg0106',70,1,1);
/*!40000 ALTER TABLE `maestro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-10 12:27:43
