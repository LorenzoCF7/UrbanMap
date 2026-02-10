# UrbanMap 🏠

**Sistema de Gestión Inmobiliaria Desktop con JavaFX**

UrbanMap es una aplicación de escritorio desarrollada en JavaFX que permite gestionar y visualizar propiedades inmobiliarias (casas, pisos y locales comerciales) con una interfaz moderna e intuitiva.

---

## 📋 Características

### **Funcionalidades principales**

- 🔐 **Sistema de autenticación** - Login de usuarios con validación
- 🏘️ **Gestión de propiedades** - Visualización de casas, pisos y locales comerciales
- 🔍 **Búsqueda y filtros avanzados** - Por tipo, precio, características y disponibilidad
- 📊 **Ordenamiento dinámico** - Por precio, fecha o nombre
- 🖼️ **Galería de imágenes** - Visualización de fotos de cada propiedad
- 📱 **Vista detallada** - Información completa con estadísticas y características
- 💰 **Calculadora de hipoteca** - Estimación mensual automática
- 🛒 **Sistema de compra** - Registro de transacciones en base de datos
- 👤 **Perfil de usuario** - Visualización del usuario activo en la barra lateral

### **Tipos de propiedad soportados**

- **Casa**: Vivienda unifamiliar con información de plantas, jardín y garaje
- **Piso**: Apartamento con número de habitaciones, planta y ascensor
- **Local**: Espacio comercial con superficie y almacén

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Versión                 | Uso                           |
| ---------- | ----------------------- | ----------------------------- |
| **Java**   | 21                      | Lenguaje de programación      |
| **JavaFX** | 21                      | Framework de interfaz gráfica |
| **MySQL**  | 8.x                     | Base de datos relacional      |
| **Maven**  | -                       | Gestión de dependencias       |
| **JDBC**   | mysql-connector-j 8.3.0 | Conexión a base de datos      |

---

## 📦 Estructura del proyecto

```
UrbanMap/
├── src/
│   ├── main/
│   │   ├── java/org/example/urbanmap/
│   │   │   ├── controlador/           # Controladores MVC
│   │   │   │   ├── CompraController.java
│   │   │   │   ├── ImagenPropiedadController.java
│   │   │   │   ├── LoginController.java
│   │   │   │   ├── MainController.java
│   │   │   │   ├── PropiedadController.java
│   │   │   │   ├── PropiedadDetalleController.java
│   │   │   │   └── UsuarioController.java
│   │   │   ├── modelo/                # Modelos de datos
│   │   │   │   ├── Casa.java
│   │   │   │   ├── Compra.java
│   │   │   │   ├── ImagenPropiedad.java
│   │   │   │   ├── Local.java
│   │   │   │   ├── Piso.java
│   │   │   │   ├── Propiedad.java
│   │   │   │   ├── Usuario.java
│   │   │   │   └── Vivienda.java
│   │   │   ├── ConexionBD.java        # Gestión de conexión BD
│   │   │   └── HelloApplication.java  # Clase principal
│   │   ├── resources/org/example/urbanmap/
│   │   │   ├── login.fxml             # Vista de login
│   │   │   ├── mainView.fxml          # Vista principal
│   │   │   ├── navBar.fxml            # Barra de navegación
│   │   │   ├── propertyDetail.fxml    # Vista de detalle
│   │   │   ├── login.css              # Estilos de login
│   │   │   ├── mainView.css           # Estilos principal
│   │   │   ├── navBar.css             # Estilos navbar
│   │   │   └── propertyDetail.css     # Estilos detalle
│   │   └── sql/
│   │       ├── UrbanMap_bd.sql        # Creación de BD
│   │       └── UrbanMap_datos_prueba.sql  # Datos de ejemplo
├── pom.xml                            # Configuración Maven
└── README.md
```

---

## 🚀 Instalación y configuración

### **Requisitos previos**

1. **Java Development Kit (JDK) 21** o superior
2. **MySQL Server 8.x** instalado y ejecutándose
3. **Maven** (incluido en el wrapper del proyecto)

### **Pasos de instalación**

#### 1️⃣ **Clonar o descargar el proyecto**

```bash
git clone <url-repositorio>
cd UrbanMap
```

#### 2️⃣ **Configurar la base de datos**

**Opción A - Desde consola MySQL:**

```bash
# Iniciar sesión en MySQL
mysql -u root -p

# Importar el esquema
source src/main/sql/UrbanMap_bd.sql

# Importar datos de prueba
source src/main/sql/UrbanMap_datos_prueba.sql
```

**Opción B - Desde línea de comandos:**

```bash
mysql -u root -p < src/main/sql/UrbanMap_bd.sql
mysql -u root -p < src/main/sql/UrbanMap_datos_prueba.sql
```

#### 3️⃣ **Configurar las credenciales de BD**

Editar `src/main/java/org/example/urbanmap/ConexionBD.java`:

```java
private static final String USUARIO = "root";      // Tu usuario MySQL
private static final String CONTRASEÑA = "";        // Tu contraseña MySQL
```

#### 4️⃣ **Compilar el proyecto**

```bash
# Windows
.\mvnw.cmd clean compile

# Linux/Mac
./mvnw clean compile
```

#### 5️⃣ **Ejecutar la aplicación**

```bash
# Windows
.\mvnw.cmd javafx:run

# Linux/Mac
./mvnw javafx:run
```

---

## 👤 Usuarios de prueba

La base de datos incluye usuarios predefinidos para pruebas:

| Usuario        | Contraseña      | Rol           | Descripción      |
| -------------- | --------------- | ------------- | ---------------- |
| `admin`        | `admin123`      | Administrador | Acceso completo  |
| `gerente`      | `gerente456`    | Administrador | Gestión avanzada |
| `juan_perez`   | `password123`   | Usuario       | Usuario estándar |
| `maria_garcia` | `miPassword789` | Usuario       | Usuario estándar |

**Nota**: En la implementación actual, el login es funcional pero todas las operaciones están disponibles para cualquier usuario autenticado.

---

## 🎨 Capturas de pantalla

### Pantalla de Login

- Interfaz moderna con validación de credenciales
- Acceso directo a la base de datos de usuarios

### Vista Principal

- Listado de propiedades en tarjetas con imágenes
- Filtros laterales por tipo, precio y características
- Búsqueda en tiempo real
- Ordenamiento personalizable

### Vista de Detalle

- Galería de imágenes con carrusel
- Información completa de la propiedad
- Estadísticas visuales
- Calculadora de hipoteca
- Botones de acción (Comprar, Contactar)

---

## 🏗️ Arquitectura

### **Patrón de diseño**: MVC (Modelo-Vista-Controlador)

#### **Modelo**

- Clases POJO con herencia (`Propiedad` → `Casa`, `Piso`, `Local`)
- Interfaz `Vivienda` para contrato común
- Single Table Inheritance en base de datos

#### **Vista**

- Archivos FXML para estructura
- Archivos CSS para estilos (diseño moderno inspirado en aplicaciones web)
- Componentes JavaFX (VBox, HBox, StackPane, ScrollPane, etc.)

#### **Controlador**

- Controladores CRUD para cada entidad
- Gestión de eventos de usuario
- Lógica de navegación entre vistas

### **Base de datos**

**Diagrama de relaciones:**

```
usuario (1) ──── (N) compra (N) ──── (1) propiedad
                                          │
                                          │ (1)
                                          │
                                          └─── (N) imagen_propiedad
                                          │
                                          │ (1)
                                          │
                                          └─── (1) tipo_propiedad
```

**Tablas principales:**

- `usuario`: Credenciales y perfiles de usuario
- `propiedad`: Datos de casas, pisos y locales (Single Table)
- `tipo_propiedad`: Catálogo de tipos (Casa, Piso, Local)
- `compra`: Registro de transacciones
- `imagen_propiedad`: URLs de imágenes de propiedades

---

## 🔧 Funcionalidades técnicas destacadas

### **1. Carga dinámica de vistas**

```java
PropiedadDetalleController.cargarDetalleEnContenedor(
    contentArea, propiedad, this::cargarListadoPropiedades
);
```

- Navegación sin ventanas adicionales
- Callbacks para volver a la vista anterior

### **2. Filtrado avanzado**

- Combinación de múltiples criterios (tipo, precio, características)
- Actualización en tiempo real
- Ordenamiento dinámico

### **3. Manejo robusto de errores**

- Try-catch completos con logging
- Validación de recursos FXML
- Manejo de excepciones de BD

### **4. Carga de imágenes desde URLs**

- Soporte para imágenes remotas (Unsplash, etc.)
- Carga en background para no bloquear UI
- Placeholders para imágenes faltantes

### **5. Patrón Singleton para conexión BD**

```java
Connection connection = ConexionBD.getConexion();
```

- Una sola instancia de conexión
- Gestión automática del ciclo de vida

---

## 📝 Mejoras futuras

- [ ] Sistema de roles con permisos diferenciados
- [ ] Edición de propiedades desde la interfaz
- [ ] Mapa interactivo con coordenadas reales
- [ ] Generación de reportes en PDF
- [ ] Sistema de favoritos persistente
- [ ] Historial de búsquedas
- [ ] Notificaciones en tiempo real
- [ ] Integración con APIs de mapas (Google Maps, OpenStreetMap)
- [ ] Modo oscuro
- [ ] Exportación de datos a Excel/CSV

---

## 🐛 Resolución de problemas

### **Error: No se puede conectar a MySQL**

```
✗ Error: No se pudo conectar a la base de datos
```

**Solución:**

1. Verificar que MySQL esté ejecutándose
2. Revisar credenciales en `ConexionBD.java`
3. Confirmar que el puerto 3306 esté disponible
4. Verificar que la BD `UrbanMap_bd` exista

### **Error: LoadException en FXML**

```
javafx.fxml.LoadException: Invalid path
```

**Solución:**

1. Verificar que no haya caracteres especiales sin escapar en FXML
2. Confirmar que los archivos CSS estén en `src/main/resources`
3. Limpiar y recompilar: `mvnw clean compile`

### **Error: Imágenes no se cargan**

**Solución:**

1. Verificar conexión a Internet (URLs de Unsplash)
2. Comprobar que las URLs en BD sean válidas
3. Revisar logs en consola para errores de carga

---

## 👥 Autores

**Proyecto UrbanMap** - Sistema de Gestión Inmobiliaria  
Desarrollado como proyecto educativo de JavaFX

---

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

---

## 📞 Contacto y soporte

Para más información o soporte:

- 📧 Email: info@urbanmap.com
- 🌐 Web: www.urbanmap.com
- 📱 Teléfono: +34 900 123 456

---

**¡Gracias por usar UrbanMap! 🏠✨**
