package org.example.urbanmap.controlador;

import org.example.urbanmap.modelo.ImagenPropiedad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador CRUD para la entidad ImagenPropiedad.
 */
public class ImagenPropiedadController {

    private final Connection connection;

    public ImagenPropiedadController() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    /**
     * Inserta una nueva imagen de propiedad en la base de datos.
     */
    public boolean insertar(ImagenPropiedad imagen) {
        String sql = "INSERT INTO imagen_propiedad (id_propiedad, url_imagen) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, imagen.getIdPropiedad());
            ps.setString(2, imagen.getUrlImagen());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    imagen.setIdImagen(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar imagen: " + e.getMessage());
        }
        return false;
    }

    /**
     * Obtiene una imagen por su ID.
     */
    public ImagenPropiedad obtenerPorId(int id) {
        String sql = "SELECT * FROM imagen_propiedad WHERE id_imagen = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearImagen(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener imagen: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todas las imágenes asociadas a una propiedad.
     */
    public List<ImagenPropiedad> obtenerPorPropiedad(int idPropiedad) {
        List<ImagenPropiedad> imagenes = new ArrayList<>();
        String sql = "SELECT * FROM imagen_propiedad WHERE id_propiedad = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPropiedad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                imagenes.add(mapearImagen(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener imágenes de la propiedad: " + e.getMessage());
        }
        return imagenes;
    }

    /**
     * Obtiene todas las imágenes de la base de datos.
     */
    public List<ImagenPropiedad> obtenerTodas() {
        List<ImagenPropiedad> imagenes = new ArrayList<>();
        String sql = "SELECT * FROM imagen_propiedad";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                imagenes.add(mapearImagen(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener imágenes: " + e.getMessage());
        }
        return imagenes;
    }

    /**
     * Actualiza una imagen existente.
     */
    public boolean actualizar(ImagenPropiedad imagen) {
        String sql = "UPDATE imagen_propiedad SET id_propiedad = ?, url_imagen = ? WHERE id_imagen = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, imagen.getIdPropiedad());
            ps.setString(2, imagen.getUrlImagen());
            ps.setInt(3, imagen.getIdImagen());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar imagen: " + e.getMessage());
        }
        return false;
    }

    /**
     * Elimina una imagen por su ID.
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM imagen_propiedad WHERE id_imagen = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar imagen: " + e.getMessage());
        }
        return false;
    }

    /**
     * Elimina todas las imágenes de una propiedad.
     */
    public boolean eliminarPorPropiedad(int idPropiedad) {
        String sql = "DELETE FROM imagen_propiedad WHERE id_propiedad = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPropiedad);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar imágenes de la propiedad: " + e.getMessage());
        }
        return false;
    }

    private ImagenPropiedad mapearImagen(ResultSet rs) throws SQLException {
        return new ImagenPropiedad(
                rs.getInt("id_imagen"),
                rs.getInt("id_propiedad"),
                rs.getString("url_imagen")
        );
    }
}
