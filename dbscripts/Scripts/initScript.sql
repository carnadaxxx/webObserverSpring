CREATE DATABASE IF NOT EXISTS webObserverDB;

USE webObserverDB;

/*Crea la tabla Usuario*/
CREATE TABLE IF NOT EXISTS usuario (
	idusuario INT(5) NOT NULL AUTO_INCREMENT,
	nombres VARCHAR(300) NOT NULL,
	apellidos VARCHAR(300) NOT NULL,
	email VARCHAR(300) NOT NULL,
	username VARCHAR(300) NOT NULL,
	password VARCHAR(300) NOT NULL,
	PRIMARY KEY(idusuario)	
);

/*Crea la tabla Sitio*/
CREATE TABLE IF NOT EXISTS sitio (
	idsitio INT(5) NOT NULL AUTO_INCREMENT,
	url VARCHAR(300) NOT NULL,
    nombre VARCHAR(300) NOT NULL,
    PRIMARY KEY(idsitio)
);