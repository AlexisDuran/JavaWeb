create database cursocsi;
USE cursocsi;
create table administrador (
id int not null AUTO_INCREMENT,
usuario varchar(50),
contraseña varchar(50),
primary key(id)
);
select * from administrador;
insert into administrador(usuario,contraseña)values("admin","admin");
delete from administrador where id = 2;
select usuario,contraseña from administrador where usuario = 'admin' and contraseña = 'admin';

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(50) NOT NULL,
  `clave` int(11) NOT NULL,
  `estatus` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `matricula` int(11) NOT NULL,
  `estatus` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `alumno_materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_materia` (
  `id` int(11) NOT NULL auto_increment,
  `materiaId` int(11) NOT NULL,
  `alumnoId` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `materiaId` (`materiaId`),
  KEY `alumnoId` (`alumnoId`),
  CONSTRAINT `alumno_materia_ibfk_1` FOREIGN KEY (`materiaId`) REFERENCES `materia` (`id`),
  CONSTRAINT `alumno_materia_ibfk_2` FOREIGN KEY (`alumnoId`) REFERENCES `alumno` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id` int(11) NOT NULL auto_increment,
  `materiaid` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estatus` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `grupo_ibfk_1` (`materiaid`),
  CONSTRAINT `grupo_ibfk_1` FOREIGN KEY (`materiaid`) REFERENCES `materia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `tipoempleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoempleado` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

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

SELECT * FROM alumno;
SELECT (nombre,usuario,matricula,estatus) FROM alumno where nombre = '' and usuario = '' and matricula = 1 and estatus =1 ;
INSERT INTO `alumno` VALUES (1,'Alfredo Soto','alfr3dosv','pass',666,1),(2,'Cesarv','c2','c3',876,1),(3,'Test','test','test',168,1),(7,'Isidro Amaury Tobias Quiroz','aryT','1234',1791318,1),(8,'ari','a15','52',45,6),(18,'Gustavo Zapata','Alumno','password',1549875,1),(19,'Test01','test123','imatest',1881297,1),(20,'Nicolas','NicoF','contra',1862570,1),(21,'Saul','alumno','a8b9c10',1549875,1),(26,'prueba2','prueba2','contra',123456,1),(27,'Oscar','Oscar1','contraseÃ±a',7568403,1),(30,'Denise Torres','dt11','denise123',1615030,1),(32,'test','test11','1234',183748,1),(33,'Nata','natalie','Nata1',17894,1),(34,'brayan','Brayan','1234',1797231,1),(35,'Rafael','Rafa','matanga',1813593,1),(41,'dfsda','fdsa','dfasd',342423,1);
insert into alumno(nombre,usuario,contraseña,matricula,estatus) VALUES ('ALEXIS DURAN3','alexis','alexis',1479832,666);
update alumno set nombre = PabloO;
delete from alumno where id = 3 ;

SELECT * FROM materia;
INSERT INTO `materia` VALUES (1,'Temas basicos de Quimica',1234,0),(2,'Español',1233,1),(4,'Quimica',0,1),(7,'Bio',12,1),(8,'Geografia',555,1),(9,'Mecanografia',98,1),(10,'Programacion',159,1),(11,'Ecuaciones 3',232,0),(15,'Doo',52,1),(16,'Metafisica',326,1),(18,'Animacion',864,1);
delete from materia where id = 8;

SELECT * FROM grupo;
INSERT INTO `grupo` VALUES (2,4,2,1),(3,8,9,1),(4,7,30,0),(5,9,1,0),(7,7,30,0),(8,1,3,1),(9,8,28,1),(11,15,29,1),(13,2,0,1);
INSERT INTO `grupo` VALUES (6,6,6);
delete from grupo where id = 2;

SELECT * FROM alumno_materia;
INSERT INTO `alumno_materia` VALUES (1,8,7),(2,2,7),(3,9,7),(5,8,2),(6,8,3),(7,4,2),(8,8,2),(9,15,2);
INSERT INTO `alumno_materia` VALUES (1,8,7);


SELECT * FROM tipoempleado;
INSERT INTO `tipoempleado` VALUES (1,'M.T. Quimicas'),(2,'M.T. Fisica');

SELECT * FROM maestro;
INSERT INTO `maestro` VALUES (2,'Pablo','Pablito','Terceras',420,1,1),(4,'Solis','sol4','password',2,1,1),(5,'Prueba','Pruebaa','1234gg',5,NULL,1),(8,'Adrian','ad97','pwd',1,2,1),(31,'Saul ','Sa58','3369',8,NULL,1),(32,'Maestro','Maestrox','maestro',10,NULL,1),(35,'Test02','Test02','imasecondtest',18,1,1),(36,'Luis','Luis1','null',6,1,0),(37,'Romeo','romsg','romeo123',862,1,1),(38,'Test','Test010','123456',2532,1,1),(39,'andres','alt09','245asd',1,1,1),(40,'asdasd','asdasd<','dasda<<<',12,NULL,1),(41,'Maestro','Maestro','Maestro',36,NULL,1),(43,'Belem','Bema','Bema12',13456,1,1),(44,'Gerardo Mata','ggmr','jaeg0106',70,1,1);
INSERT INTO `maestro` VALUES (10,'ALEXIS','alexis','alexis',666,1,666);
INSERT INTO `maestro`(nombre,usuario,contraseña,no_empleado,tipoEmpleadoId,estatus) VALUES ('ALEXIS3','alexis','alexis',666,1,666);

update alumno set nombre = 'PabloO',usuario='c22',contraseña ='c33',matricula = 8766,estatus=2 where id = 2;