-- Script con datos de prueba para UrbanMap
-- Este script debe ejecutarse DESPUÉS de UrbanMap_bd.sql

USE UrbanMap_bd;

-- ============================================================
-- INSERTAR USUARIOS
-- ============================================================
INSERT INTO usuario (nombre_usuario, contraseña, usu_admin) VALUES
-- Usuarios administradores
('admin', 'admin123', 1),
('gerente', 'gerente456', 1),
-- Usuarios normales
('juan_perez', 'password123', 0),
('maria_garcia', 'miPassword789', 0),
('carlos_lopez', 'carlos2025', 0),
('anna_martinez', 'anna_secure', 0),
('david_rodriguez', 'david123', 0),
('laura_fernandez', 'laura456', 0),
('miguel_sanchez', 'miguel2025', 0),
('sandra_ruiz', 'sandra789', 0),
('pablo_moreno', 'pablo_pass', 0),
('elena_jimenez', 'elena2025', 0),
('antonio_vargas', 'antonio123', 0),
('sofia_blanco', 'sofia_pwd', 0),
('jorge_herrera', 'jorge456', 0),
('rosa_molina', 'rosa2025', 0),
('francisco_iglesias', 'francisco789', 0),
('beatriz_medina', 'beatriz_pass', 0),
('ramon_navarro', 'ramon2025', 0),
('teresa_guerrero', 'teresa123', 0),
('sergio_gutierrez', 'sergio456', 0);

-- ============================================================
-- INSERTAR CASAS (id_tipo = 1)
-- ============================================================
INSERT INTO propiedad (nombre, id_tipo, precio, latitud, longitud, descripcion, disponible, num_plantas, tiene_jardin, tiene_garaje) VALUES
('Casa Moderna Centro', 1, 450000, 40.4168, -3.7038, 'Hermosa casa moderna en el centro urbano con vistas panorámicas', 1, 3, 1, 1),
('Chalet Campestre', 1, 380000, 40.3500, -3.8000, 'Casa de campo con gran jardín y terraza', 1, 2, 1, 1),
('Vivienda Unifamiliar Acogedora', 1, 320000, 40.5200, -3.6500, 'Bonita casa familiar con patio trasero', 1, 2, 1, 0),
('Caserón Histórico', 1, 520000, 40.4200, -3.7200, 'Casa con carácter histórico, bien conservada', 1, 4, 1, 1),
('Casa Residencial Nueva', 1, 425000, 40.3800, -3.7500, 'Casa moderna recién terminada, lista para habitar', 1, 3, 1, 1),
('Hogar Tranquilo Barrio Residencial', 1, 395000, 40.4400, -3.6800, 'Casa en zona residencial tranquila', 1, 2, 1, 1),
('Villa de Lujo Zona Exclusiva', 1, 680000, 40.3200, -3.7800, 'Lujosa villa con amplios espacios', 0, 3, 1, 1),
('Casa Aqueísima Barrio Nuevo', 1, 340000, 40.5000, -3.7300, 'Casa en barrio consolidado', 1, 2, 0, 1),
('Sueño Inmobiliario Familiar', 1, 410000, 40.4600, -3.6900, 'Perfecta para familias, zona escolar', 1, 3, 1, 0),
('Retiro Privado Afueras', 1, 370000, 40.2800, -3.8200, 'Casa aislada en zona tranquila', 1, 2, 1, 1);

-- ============================================================
-- INSERTAR PISOS (id_tipo = 2)
-- ============================================================
INSERT INTO propiedad (nombre, id_tipo, precio, latitud, longitud, descripcion, disponible, planta, tiene_ascensor, num_habitaciones) VALUES
('Piso Céntrico Moderno', 2, 280000, 40.4170, -3.7035, 'Piso de lujo en pleno centro', 1, 5, 1, 3),
('Apartamento Familia Numerosa', 2, 320000, 40.4200, -3.7000, 'Amplio piso con 4 dormitorios', 1, 3, 1, 4),
('Estudio Compacto Zona Centro', 2, 150000, 40.4150, -3.7050, 'Perfecto para estudiantes o profesionales', 1, 2, 0, 1),
('Piso Turístico Rentable', 2, 220000, 40.4190, -3.7020, 'Ideal para inversión con potencial turístico', 1, 4, 1, 2),
('Dúplex de Lujo Vistas', 2, 450000, 40.4210, -3.7000, 'Dúplex con terrazas y vistas al parque', 1, 7, 1, 3),
('Piso Familiar Barrio Tradicional', 2, 250000, 40.4100, -3.7100, 'Piso acogedor en zona tranquila', 1, 2, 0, 3),
('Apartamento Ejecutivo Zona Alta', 2, 380000, 40.4250, -3.6950, 'Piso premium con acabados de lujo', 0, 8, 1, 3),
('Piso Reformado Sector Centro', 2, 290000, 40.4180, -3.7030, 'Recién reformado, impecable', 1, 3, 1, 2),
('Mini Apartamento Ahorrador', 2, 120000, 40.4160, -3.7040, 'Opción económica bien ubicada', 1, 1, 0, 1),
('Penthouse Extraordinario', 2, 650000, 40.4220, -3.6980, 'Penthouse con terrazas espectaculares', 1, 10, 1, 4),
('Piso Comunicado Amplio', 2, 310000, 40.4140, -3.7060, 'Dos viviendas unidas, muy espacioso', 1, 4, 1, 5),
('Apartamento Zona Emergente', 2, 180000, 40.3950, -3.7200, 'En zona en desarrollo, con potencial', 1, 2, 0, 2),
('Piso Inversión Continua Demanda', 2, 200000, 40.4100, -3.7080, 'En zona apta para alquiler continuo', 1, 3, 1, 2),
('Studio Premium Ubicación Golden', 2, 175000, 40.4195, -3.7025, 'Estudio de calidad en ubicación premium', 1, 5, 1, 1),
('Piso para Renovar Potencial', 2, 160000, 40.4130, -3.7090, 'Necesita reforma pero buen precio', 1, 2, 0, 2);

-- ============================================================
-- INSERTAR LOCALES (id_tipo = 3)
-- ============================================================
INSERT INTO propiedad (nombre, id_tipo, precio, latitud, longitud, descripcion, disponible, superficie, tiene_almacen) VALUES
('Local Comercial Premium Centro', 3, 280000, 40.4175, -3.7032, 'Excelente local en corazón comercial', 1, 150, 1),
('Oficina Moderna Centro Negocios', 3, 250000, 40.4180, -3.7020, 'Perfecta para empresa emergente', 1, 120, 0),
('Tienda Ropa Zona Exclusiva', 3, 320000, 40.4160, -3.7040, 'Local para comercio de moda', 1, 180, 1),
('Garaje y Trastero Sector Centro', 3, 45000, 40.4200, -3.7010, 'Espacio de almacenaje seguro', 1, 25, 0),
('Local Gastronómico Trendy', 3, 380000, 40.4190, -3.7015, 'Ideal para restaurante o bar de copas', 1, 200, 1),
('Oficina Consultoría Lujo', 3, 290000, 40.4170, -3.7030, 'Completamente equipada y lista', 1, 140, 0),
('Espacio Coworking innovador', 3, 350000, 40.4185, -3.7035, 'Dividible en módulos', 1, 250, 1),
('Kiosco Emblemático Zona Centro', 3, 35000, 40.4195, -3.7022, 'Local pequeño pero rentable', 1, 15, 0),
('Taller Mecánico Amplio', 3, 420000, 40.3800, -3.7500, 'Con zona de almacenaje y oficina', 1, 350, 1),
('Clínica Dental Sector Premium', 3, 310000, 40.4210, -3.7025, 'Listo para uso profesional médico', 1, 160, 0),
('Salón de Belleza Equipado', 3, 180000, 40.4165, -3.7045, 'Completamente adaptado', 1, 80, 0),
('Local Multiusos Flexible', 3, 200000, 40.4175, -3.7050, 'Adaptable a varios negocios', 1, 120, 1),
('Almacén Distribución Logística', 3, 550000, 40.3500, -3.8000, 'Gran espacio para operaciones', 1, 1000, 1),
('Academia Idiomas Zona Centro', 3, 240000, 40.4180, -3.7040, 'Con aulas y espacios administrativos', 1, 140, 0),
('Estudio Fotográfico Profesional', 3, 220000, 40.4190, -3.7030, 'Con ciclorama y zona técnica', 1, 110, 1);

-- ============================================================
-- INSERTAR IMÁGENES DE PROPIEDADES
-- ============================================================
INSERT INTO imagen_propiedad (id_propiedad, url_imagen) VALUES
-- Imágenes de Casas (propiedades 1-10)
(1, 'https://images.unsplash.com/photo-1570129477492-45ac003cdd4e?w=500&h=400'),
(1, 'https://images.unsplash.com/photo-1572120471610-3f4ee4e529a9?w=500&h=400'),
(2, 'https://images.unsplash.com/photo-1564013799919-ab600027ffc6?w=500&h=400'),
(2, 'https://images.unsplash.com/photo-1570129477492-45ac003cdd4e?w=500&h=400'),
(3, 'https://images.unsplash.com/photo-1600585154340-be6161a56a0c?w=500&h=400'),
(3, 'https://images.unsplash.com/photo-1570129477492-45ac003cdd4e?w=500&h=400'),
(4, 'https://images.unsplash.com/photo-1564013799919-ab600027ffc6?w=500&h=400'),
(5, 'https://images.unsplash.com/photo-1572120471610-3f4ee4e529a9?w=500&h=400'),
(5, 'https://images.unsplash.com/photo-1570129477492-45ac003cdd4e?w=500&h=400'),
(6, 'https://images.unsplash.com/photo-1600585154340-be6161a56a0c?w=500&h=400'),
(7, 'https://images.unsplash.com/photo-1564013799919-ab600027ffc6?w=500&h=400'),
(7, 'https://images.unsplash.com/photo-1572120471610-3f4ee4e529a9?w=500&h=400'),
(8, 'https://images.unsplash.com/photo-1570129477492-45ac003cdd4e?w=500&h=400'),
(9, 'https://images.unsplash.com/photo-1600585154340-be6161a56a0c?w=500&h=400'),
(10, 'https://images.unsplash.com/photo-1564013799919-ab600027ffc6?w=500&h=400'),
-- Imágenes de Pisos (propiedades 11-25)
(11, 'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=500&h=400'),
(11, 'https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=400'),
(12, 'https://images.unsplash.com/photo-1468022694152-10011e2e8b7f?w=500&h=400'),
(12, 'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=500&h=400'),
(13, 'https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=400'),
(13, 'https://images.unsplash.com/photo-1565693566449-631209a01d5b?w=500&h=400'),
(14, 'https://images.unsplash.com/photo-1468022694152-10011e2e8b7f?w=500&h=400'),
(14, 'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=500&h=400'),
(15, 'https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=400'),
(16, 'https://images.unsplash.com/photo-1565693566449-631209a01d5b?w=500&h=400'),
(16, 'https://images.unsplash.com/photo-1468022694152-10011e2e8b7f?w=500&h=400'),
(17, 'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=500&h=400'),
(18, 'https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=400'),
(19, 'https://images.unsplash.com/photo-1565693566449-631209a01d5b?w=500&h=400'),
(20, 'https://images.unsplash.com/photo-1468022694152-10011e2e8b7f?w=500&h=400'),
(21, 'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=500&h=400'),
(21, 'https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=400'),
(22, 'https://images.unsplash.com/photo-1565693566449-631209a01d5b?w=500&h=400'),
(23, 'https://images.unsplash.com/photo-1468022694152-10011e2e8b7f?w=500&h=400'),
(24, 'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=500&h=400'),
(25, 'https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=400'),
-- Imágenes de Locales (propiedades 26-40)
(26, 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=400'),
(26, 'https://images.unsplash.com/photo-1556740738-b6a63e27c4df?w=500&h=400'),
(27, 'https://images.unsplash.com/photo-1553531088-16512a64e7a8?w=500&h=400'),
(27, 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=400'),
(28, 'https://images.unsplash.com/photo-1556740738-b6a63e27c4df?w=500&h=400'),
(28, 'https://images.unsplash.com/photo-1553531088-16512a64e7a8?w=500&h=400'),
(29, 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=400'),
(30, 'https://images.unsplash.com/photo-1556740738-b6a63e27c4df?w=500&h=400'),
(31, 'https://images.unsplash.com/photo-1553531088-16512a64e7a8?w=500&h=400'),
(31, 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=400'),
(32, 'https://images.unsplash.com/photo-1556740738-b6a63e27c4df?w=500&h=400'),
(33, 'https://images.unsplash.com/photo-1553531088-16512a64e7a8?w=500&h=400'),
(34, 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=400'),
(35, 'https://images.unsplash.com/photo-1556740738-b6a63e27c4df?w=500&h=400'),
(36, 'https://images.unsplash.com/photo-1553531088-16512a64e7a8?w=500&h=400'),
(36, 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=400'),
(37, 'https://images.unsplash.com/photo-1556740738-b6a63e27c4df?w=500&h=400'),
(38, 'https://images.unsplash.com/photo-1553531088-16512a64e7a8?w=500&h=400'),
(39, 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=400'),
(40, 'https://images.unsplash.com/photo-1556740738-b6a63e27c4df?w=500&h=400');

-- ============================================================
-- INSERTAR COMPRAS
-- ============================================================
INSERT INTO compra (id_usuario_compra, id_propiedad_compra, fecha_compra) VALUES
-- Compras del usuario 3 (juan_perez)
(3, 1, '2024-01-15'),
(3, 13, '2024-06-20'),
-- Compras del usuario 4 (maria_garcia)
(4, 2, '2024-03-10'),
(4, 11, '2024-08-05'),
-- Compras del usuario 5 (carlos_lopez)
(5, 3, '2024-02-28'),
(5, 26, '2024-05-12'),
-- Compras del usuario 6 (anna_martinez)
(6, 4, '2024-04-11'),
(6, 12, '2024-09-03'),
-- Compras del usuario 7 (david_rodriguez)
(7, 5, '2024-01-22'),
(7, 14, '2024-07-18'),
-- Compras del usuario 8 (laura_fernandez)
(8, 6, '2024-02-14'),
(8, 27, '2024-04-25'),
(8, 15, '2024-10-08'),
-- Compras del usuario 9 (miguel_sanchez)
(9, 7, '2024-03-30'),
(9, 28, '2024-08-22'),
-- Compras del usuario 10 (sandra_ruiz)
(10, 8, '2024-05-01'),
(10, 16, '2024-09-14'),
-- Compras del usuario 11 (pablo_moreno)
(11, 9, '2024-02-19'),
(11, 29, '2024-06-11'),
-- Compras del usuario 12 (elena_jimenez)
(12, 10, '2024-04-07'),
(12, 17, '2024-07-30'),
(12, 30, '2024-11-02'),
-- Compras del usuario 13 (antonio_vargas)
(13, 18, '2024-03-15'),
(13, 31, '2024-08-09'),
-- Compras del usuario 14 (sofia_blanco)
(14, 19, '2024-05-20'),
(14, 32, '2024-10-16'),
-- Compras del usuario 15 (jorge_herrera)
(15, 11, '2024-01-28'),
(15, 33, '2024-06-24'),
(15, 20, '2024-09-11'),
-- Compras del usuario 16 (rosa_molina)
(16, 21, '2024-04-18'),
(16, 34, '2024-08-30'),
-- Compras del usuario 17 (francisco_iglesias)
(17, 22, '2024-02-25'),
(17, 35, '2024-07-14'),
-- Compras del usuario 18 (beatriz_medina)
(18, 23, '2024-03-22'),
(18, 36, '2024-09-27'),
(18, 24, '2024-11-15'),
-- Compras del usuario 19 (ramon_navarro)
(19, 12, '2024-05-09'),
(19, 37, '2024-10-02'),
-- Compras del usuario 20 (teresa_guerrero)
(20, 25, '2024-04-30'),
(20, 38, '2024-08-16'),
-- Compras del usuario 21 (sergio_gutierrez)
(21, 26, '2024-01-11'),
(21, 39, '2024-06-28'),
(21, 40, '2024-09-19');

-- ============================================================
-- ESTADÍSTICAS FINALES
-- ============================================================
-- Verificar cantidad de registros insertados
SELECT 'ESTADÍSTICAS DE INSERCIÓN' AS 'Sección';
SELECT COUNT(*) AS 'Total Usuarios' FROM usuario;
SELECT COUNT(*) AS 'Total Propiedades' FROM propiedad;
SELECT COUNT(*) AS 'Total Imágenes' FROM imagen_propiedad;
SELECT COUNT(*) AS 'Total Compras' FROM compra;

-- Desglose por tipo de propiedad
SELECT 
	CASE id_tipo 
		WHEN 1 THEN 'Casas'
		WHEN 2 THEN 'Pisos'
		WHEN 3 THEN 'Locales'
	END AS 'Tipo Propiedad',
	COUNT(*) AS 'Cantidad'
FROM propiedad
GROUP BY id_tipo;
