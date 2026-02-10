package org.example.urbanmap.controlador;

import org.example.urbanmap.ConexionBD;
import org.example.urbanmap.modelo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador CRUD para la entidad Propiedad y sus subtipos (Casa, Piso, Local).
 * Utiliza la tabla única 'propiedad' con campos específicos por tipo (Single Table Inheritance).
 */
public class PropiedadController {

    private final Connection connection;

    // IDs de tipo según la tabla tipo_propiedad
    private static final int TIPO_CASA = 1;
    private static final int TIPO_PISO = 2;
    private static final int TIPO_LOCAL = 3;

    public PropiedadController() {
        this.connection = ConexionBD.getConexion();
    }

    /**
     * Inserta una nueva propiedad en la base de datos.
     * Detecta automáticamente el subtipo (Casa, Piso, Local) y persiste los campos específicos.
     */
    public boolean insertar(Propiedad propiedad) {
        String sql = "INSERT INTO propiedad (nombre, id_tipo, precio, latitud, longitud, descripcion, disponible, " +
                "num_plantas, tiene_jardin, tiene_garaje, planta, tiene_ascensor, num_habitaciones, superficie, tiene_almacen) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setCommonFields(ps, propiedad);
            setSpecificFields(ps, propiedad);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    propiedad.setIdPropiedad(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar propiedad: " + e.getMessage());
        }
        return false;
    }

    /**
     * Obtiene una propiedad por su ID, devolviendo la instancia concreta (Casa, Piso o Local).
     */
    public Propiedad obtenerPorId(int id) {
        String sql = "SELECT * FROM propiedad WHERE id_propiedad = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearPropiedad(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener propiedad: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todas las propiedades de la base de datos.
     */
    public List<Propiedad> obtenerTodas() {
        List<Propiedad> propiedades = new ArrayList<>();
        String sql = "SELECT * FROM propiedad";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                propiedades.add(mapearPropiedad(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener propiedades: " + e.getMessage());
        }
        return propiedades;
    }

    /**
     * Obtiene todas las propiedades disponibles.
     */
    public List<Propiedad> obtenerDisponibles() {
        List<Propiedad> propiedades = new ArrayList<>();
        String sql = "SELECT * FROM propiedad WHERE disponible = 1";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                propiedades.add(mapearPropiedad(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener propiedades disponibles: " + e.getMessage());
        }
        return propiedades;
    }

    /**
     * Obtiene propiedades filtradas por tipo (Casa, Piso, Local).
     */
    public List<Propiedad> obtenerPorTipo(int idTipo) {
        List<Propiedad> propiedades = new ArrayList<>();
        String sql = "SELECT * FROM propiedad WHERE id_tipo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idTipo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                propiedades.add(mapearPropiedad(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener propiedades por tipo: " + e.getMessage());
        }
        return propiedades;
    }

    /**
     * Actualiza una propiedad existente.
     */
    public boolean actualizar(Propiedad propiedad) {
        String sql = "UPDATE propiedad SET nombre = ?, id_tipo = ?, precio = ?, latitud = ?, longitud = ?, " +
                "descripcion = ?, disponible = ?, num_plantas = ?, tiene_jardin = ?, tiene_garaje = ?, " +
                "planta = ?, tiene_ascensor = ?, num_habitaciones = ?, superficie = ?, tiene_almacen = ? " +
                "WHERE id_propiedad = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            setCommonFields(ps, propiedad);
            setSpecificFields(ps, propiedad);
            ps.setInt(16, propiedad.getIdPropiedad());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar propiedad: " + e.getMessage());
        }
        return false;
    }

    /**
     * Elimina una propiedad por su ID.
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM propiedad WHERE id_propiedad = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar propiedad: " + e.getMessage());
        }
        return false;
    }

    // --- Métodos privados de mapeo ---

    private void setCommonFields(PreparedStatement ps, Propiedad p) throws SQLException {
        ps.setString(1, p.getNombre());
        ps.setInt(2, p.getIdTipo());
        ps.setDouble(3, p.getPrecio());
        ps.setDouble(4, p.getLatitud());
        ps.setDouble(5, p.getLongitud());
        ps.setString(6, p.getDescripcion());
        ps.setBoolean(7, p.isDisponible());
    }

    private void setSpecificFields(PreparedStatement ps, Propiedad p) throws SQLException {
        // Resetear todos los campos específicos a null
        ps.setNull(8, Types.INTEGER);   // num_plantas
        ps.setNull(9, Types.BOOLEAN);   // tiene_jardin
        ps.setNull(10, Types.BOOLEAN);  // tiene_garaje
        ps.setNull(11, Types.INTEGER);  // planta
        ps.setNull(12, Types.BOOLEAN);  // tiene_ascensor
        ps.setNull(13, Types.INTEGER);  // num_habitaciones
        ps.setNull(14, Types.DOUBLE);   // superficie
        ps.setNull(15, Types.BOOLEAN);  // tiene_almacen

        if (p instanceof Casa casa) {
            ps.setInt(8, casa.getNumPlantas());
            ps.setBoolean(9, casa.isTieneJardin());
            ps.setBoolean(10, casa.isTieneGaraje());
        } else if (p instanceof Piso piso) {
            ps.setInt(11, piso.getPlanta());
            ps.setBoolean(12, piso.isTieneAscensor());
            ps.setInt(13, piso.getNumHabitaciones());
        } else if (p instanceof Local local) {
            ps.setDouble(14, local.getSuperficie());
            ps.setBoolean(15, local.isTieneAlmacen());
        }
    }

    private Propiedad mapearPropiedad(ResultSet rs) throws SQLException {
        int idPropiedad = rs.getInt("id_propiedad");
        String nombre = rs.getString("nombre");
        int idTipo = rs.getInt("id_tipo");
        double precio = rs.getDouble("precio");
        double latitud = rs.getDouble("latitud");
        double longitud = rs.getDouble("longitud");
        String descripcion = rs.getString("descripcion");
        boolean disponible = rs.getBoolean("disponible");

        switch (idTipo) {
            case TIPO_CASA:
                return new Casa(idPropiedad, nombre, idTipo, precio, latitud, longitud, descripcion, disponible,
                        rs.getInt("num_plantas"),
                        rs.getBoolean("tiene_jardin"),
                        rs.getBoolean("tiene_garaje"));
            case TIPO_PISO:
                return new Piso(idPropiedad, nombre, idTipo, precio, latitud, longitud, descripcion, disponible,
                        rs.getInt("planta"),
                        rs.getBoolean("tiene_ascensor"),
                        rs.getInt("num_habitaciones"));
            case TIPO_LOCAL:
                return new Local(idPropiedad, nombre, idTipo, precio, latitud, longitud, descripcion, disponible,
                        rs.getDouble("superficie"),
                        rs.getBoolean("tiene_almacen"));
            default:
                // Si el tipo no se reconoce, se crea una Casa por defecto
                return new Casa(idPropiedad, nombre, idTipo, precio, latitud, longitud, descripcion, disponible,
                        0, false, false);
        }
    }
}
