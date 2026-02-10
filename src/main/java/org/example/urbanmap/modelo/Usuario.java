package org.example.urbanmap.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo que representa un usuario del sistema.
 * Corresponde a la tabla 'usuario' de la base de datos.
 */
public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String contrasena;
    private boolean usuAdmin;
    private List<Compra> compras;

    public Usuario() {
        this.compras = new ArrayList<>();
    }

    public Usuario(int idUsuario, String nombreUsuario, String contrasena, boolean usuAdmin) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.usuAdmin = usuAdmin;
        this.compras = new ArrayList<>();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isUsuAdmin() {
        return usuAdmin;
    }

    public void setUsuAdmin(boolean usuAdmin) {
        this.usuAdmin = usuAdmin;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return String.format("Usuario[id=%d, nombre='%s', admin=%s]",
                idUsuario, nombreUsuario, usuAdmin ? "Sí" : "No");
    }
}
