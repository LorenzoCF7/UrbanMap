package org.example.urbanmap.modelo;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String contraseña;
    private boolean admin;
    
    // Constructor vacío
    public Usuario() {
    }
    
    // Constructor completo
    public Usuario(int idUsuario, String nombreUsuario, String contraseña, boolean admin) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.admin = admin;
    }
    
    // Constructor sin ID (para inserciones)
    public Usuario(String nombreUsuario, String contraseña, boolean admin) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.admin = admin;
    }
    
    // Getters y Setters
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
    
    public String getContraseña() {
        return contraseña;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public boolean isAdmin() {
        return admin;
    }
    
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", admin=" + admin +
                '}';
    }
}
