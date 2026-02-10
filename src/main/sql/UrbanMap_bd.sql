DROP DATABASE IF EXISTS UrbanMap_bd;
CREATE DATABASE IF NOT EXISTS UrbanMap_bd;
USE UrbanMap_bd;

CREATE TABLE IF NOT EXISTS usuario (
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nombre_usuario VARCHAR (50) NOT NULL,
contraseña VARCHAR (64) NOT NULL,
usu_admin BOOLEAN DEFAULT 0
);

CREATE TABLE IF NOT EXISTS propiedad(
id_propiedad INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR (50) NOT NULL,
tipo VARCHAR (24),
precio DOUBLE NOT NULL,
latitud DOUBLE,
longitud DOUBLE,
descripcion VARCHAR (200) NOT NULL,
disponible BOOLEAN DEFAULT 1
);

CREATE TABLE IF NOT EXISTS tipo_propiedad(
id_tipo INT PRIMARY KEY AUTO_INCREMENT,
nombre_tipo VARCHAR (50) NOT NULL,
descripcion VARCHAR (200)
);

CREATE TABLE IF NOT EXISTS compra(
id_compra INT PRIMARY KEY AUTO_INCREMENT,
id_usuario_compra INT,
id_propiedad_compra INT,
fecha_compra DATE,
FOREIGN KEY (id_usuario_compra) REFERENCES usuario (id_usuario),
FOREIGN KEY (id_propiedad_compra) REFERENCES propiedad (id_propiedad)
);

CREATE TABLE IF NOT EXISTS imagen_propiedad(
id_imagen INT PRIMARY KEY AUTO_INCREMENT,
url_imagen VARCHAR (120)
);

