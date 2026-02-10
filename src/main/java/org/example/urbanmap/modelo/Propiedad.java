package org.example.urbanmap.modelo;

public class Propiedad {
    private int idPropiedad;
    private String nombre;
    private String tipo;
    private double precio;
    private double latitud;
    private double longitud;
    private String descripcion;
    private boolean disponible;
    
    // Constructor vacío
    public Propiedad() {
    }
    
    // Constructor completo
    public Propiedad(int idPropiedad, String nombre, String tipo, double precio, 
                     double latitud, double longitud, String descripcion, boolean disponible) {
        this.idPropiedad = idPropiedad;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.disponible = disponible;
    }
    
    // Constructor sin ID (para inserciones)
    public Propiedad(String nombre, String tipo, double precio, 
                     double latitud, double longitud, String descripcion, boolean disponible) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.disponible = disponible;
    }
    
    // Getters y Setters
    public int getIdPropiedad() {
        return idPropiedad;
    }
    
    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public double getLatitud() {
        return latitud;
    }
    
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    
    public double getLongitud() {
        return longitud;
    }
    
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    @Override
    public String toString() {
        return "Propiedad{" +
                "idPropiedad=" + idPropiedad +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                '}';
    }
}
