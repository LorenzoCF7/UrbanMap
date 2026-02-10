error id: file:///C:/Users/juanx/Desktop/Map/UrbanMap/src/main/java/org/example/urbanmap/ConexionBD.java:java/sql/DriverManager#
file:///C:/Users/juanx/Desktop/Map/UrbanMap/src/main/java/org/example/urbanmap/ConexionBD.java
empty definition using pc, found symbol in pc: java/sql/DriverManager#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 78
uri: file:///C:/Users/juanx/Desktop/Map/UrbanMap/src/main/java/org/example/urbanmap/ConexionBD.java
text:
```scala
package org.example.urbanmap;

import java.sql.Connection;
import java.sql.@@DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    // Configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/UrbanMap_bd";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static Connection conexion = null;
    
    /**
     * Establece la conexión con la base de datos MySQL
     * @return Connection objeto de conexión
     */
    public static Connection conectar() {
        try {
            // Cargar el driver de MySQL
            Class.forName(DRIVER);
            
            // Crear la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("✓ Conexión con la base de datos establecida correctamente");
            
        } catch (ClassNotFoundException e) {
            System.out.println("✗ Error: Driver de MySQL no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("✗ Error: No se pudo conectar a la base de datos");
            System.out.println("Verifica que MySQL esté ejecutándose y que la BD 'UrbanMap_bd' exista");
            e.printStackTrace();
        }
        
        return conexion;
    }
    
    /**
     * Obtiene la conexión actual
     * @return Connection objeto de conexión
     */
    public static Connection getConexion() {
        if (conexion == null) {
            conectar();
        }
        return conexion;
    }
    
    /**
     * Cierra la conexión con la base de datos
     */
    public static void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("✓ Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al cerrar la conexión");
            e.printStackTrace();
        }
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/sql/DriverManager#