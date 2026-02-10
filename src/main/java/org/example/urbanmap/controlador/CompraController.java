package org.example.urbanmap.controlador;

import org.example.urbanmap.modelo.Compra;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador CRUD para la entidad Compra.
 */
public class CompraController {

    private final Connection connection;

    public CompraController() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    /**
     * Registra una nueva compra en la base de datos.
     */
    public boolean insertar(Compra compra) {
        String sql = "INSERT INTO compra (id_usuario_compra, id_propiedad_compra, fecha_compra) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, compra.getIdUsuarioCompra());
            ps.setInt(2, compra.getIdPropiedadCompra());
            ps.setDate(3, Date.valueOf(compra.getFechaCompra()));
            int filas = ps.executeUpdate();
            if (filas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    compra.setIdCompra(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar compra: " + e.getMessage());
        }
        return false;
    }

    /**
     * Obtiene una compra por su ID.
     */
    public Compra obtenerPorId(int id) {
        String sql = "SELECT * FROM compra WHERE id_compra = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearCompra(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener compra: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todas las compras de la base de datos.
     */
    public List<Compra> obtenerTodas() {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM compra";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                compras.add(mapearCompra(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener compras: " + e.getMessage());
        }
        return compras;
    }

    /**
     * Obtiene todas las compras de un usuario específico.
     */
    public List<Compra> obtenerPorUsuario(int idUsuario) {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM compra WHERE id_usuario_compra = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compras.add(mapearCompra(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener compras del usuario: " + e.getMessage());
        }
        return compras;
    }

    /**
     * Obtiene todas las compras asociadas a una propiedad.
     */
    public List<Compra> obtenerPorPropiedad(int idPropiedad) {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM compra WHERE id_propiedad_compra = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPropiedad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compras.add(mapearCompra(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener compras de la propiedad: " + e.getMessage());
        }
        return compras;
    }

    /**
     * Actualiza una compra existente.
     */
    public boolean actualizar(Compra compra) {
        String sql = "UPDATE compra SET id_usuario_compra = ?, id_propiedad_compra = ?, fecha_compra = ? WHERE id_compra = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, compra.getIdUsuarioCompra());
            ps.setInt(2, compra.getIdPropiedadCompra());
            ps.setDate(3, Date.valueOf(compra.getFechaCompra()));
            ps.setInt(4, compra.getIdCompra());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar compra: " + e.getMessage());
        }
        return false;
    }

    /**
     * Elimina una compra por su ID.
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM compra WHERE id_compra = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar compra: " + e.getMessage());
        }
        return false;
    }

    private Compra mapearCompra(ResultSet rs) throws SQLException {
        Date fechaSql = rs.getDate("fecha_compra");
        LocalDate fecha = (fechaSql != null) ? fechaSql.toLocalDate() : null;
        return new Compra(
                rs.getInt("id_compra"),
                rs.getInt("id_usuario_compra"),
                rs.getInt("id_propiedad_compra"),
                fecha
        );
    }
}
