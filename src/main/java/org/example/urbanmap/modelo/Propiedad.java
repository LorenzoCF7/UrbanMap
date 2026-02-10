package org.example.urbanmap.modelo;

/**
 * Clase abstracta que representa una propiedad inmobiliaria.
 * Implementa la interfaz Vivienda y sirve como base para Casa, Piso y Local.
 */
public abstract class Propiedad implements Vivienda {

    private int idPropiedad;
    private String nombre;
    private int idTipo;
    private double precio;
    private double latitud;
    private double longitud;
    private String descripcion;
    private boolean disponible;

    public Propiedad() {
        this.disponible = true;
    }

    public Propiedad(int idPropiedad, String nombre, int idTipo, double precio,
                     double latitud, double longitud, String descripcion, boolean disponible) {
        this.idPropiedad = idPropiedad;
        this.nombre = nombre;
        this.idTipo = idTipo;
        this.precio = precio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.disponible = disponible;
    }

    // --- Getters y Setters ---

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    @Override
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Método abstracto que cada subclase debe implementar
     * para devolver su tipo específico de vivienda.
     */
    @Override
    public abstract String getTipoVivienda();

    @Override
    public String getResumen() {
        return String.format("[%s] %s - %.2f€ | %s | Disponible: %s",
                getTipoVivienda(), nombre, precio, descripcion, disponible ? "Sí" : "No");
    }

    @Override
    public String toString() {
        return getResumen();
    }
}
