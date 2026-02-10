DROP DATABASE IF EXISTS UrbanMap_bd;
CREATE DATABASE IF NOT EXISTS UrbanMap_bd;
USE UrbanMap_bd;

CREATE TABLE IF NOT EXISTS usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(50) NOT NULL,
    contraseña VARCHAR(64) NOT NULL,
    usu_admin BOOLEAN DEFAULT 0
);

CREATE TABLE IF NOT EXISTS tipo_propiedad (
    id_tipo INT PRIMARY KEY AUTO_INCREMENT,
    nombre_tipo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS propiedad (
    id_propiedad INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    id_tipo INT,
    precio DOUBLE NOT NULL,
    latitud DOUBLE,
    longitud DOUBLE,
    descripcion VARCHAR(200) NOT NULL,
    disponible BOOLEAN DEFAULT 1,
    -- Campos específicos de Casa
    num_plantas INT,
    tiene_jardin BOOLEAN,
    tiene_garaje BOOLEAN,
    -- Campos específicos de Piso
    planta INT,
    tiene_ascensor BOOLEAN,
    num_habitaciones INT,
    -- Campos específicos de Local
    superficie DOUBLE,
    tiene_almacen BOOLEAN,
    FOREIGN KEY (id_tipo) REFERENCES tipo_propiedad(id_tipo)
);

CREATE TABLE IF NOT EXISTS compra (
    id_compra INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario_compra INT,
    id_propiedad_compra INT,
    fecha_compra DATE,
    FOREIGN KEY (id_usuario_compra) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_propiedad_compra) REFERENCES propiedad(id_propiedad)
);

CREATE TABLE IF NOT EXISTS imagen_propiedad (
    id_imagen INT PRIMARY KEY AUTO_INCREMENT,
    id_propiedad INT,
    url_imagen VARCHAR(120),
    FOREIGN KEY (id_propiedad) REFERENCES propiedad(id_propiedad)
);

-- Insertar tipos de propiedad por defecto
INSERT INTO tipo_propiedad (nombre_tipo, descripcion) VALUES
    ('Casa', 'Vivienda unifamiliar independiente'),
    ('Piso', 'Vivienda en edificio de varias plantas'),
    ('Local', 'Local comercial o de negocio');

