package org.example.urbanmap.modelo;

/**
 * Representa un local comercial.
 * Hereda de Propiedad e implementa Vivienda a través de ella.
 */
public class Local extends Propiedad {

    private double superficie;
    private boolean tieneAlmacen;

    public Local() {
        super();
    }

    public Local(int idPropiedad, String nombre, int idTipo, double precio,
                 double latitud, double longitud, String descripcion, boolean disponible,
                 double superficie, boolean tieneAlmacen) {
        super(idPropiedad, nombre, idTipo, precio, latitud, longitud, descripcion, disponible);
        this.superficie = superficie;
        this.tieneAlmacen = tieneAlmacen;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public boolean isTieneAlmacen() {
        return tieneAlmacen;
    }

    public void setTieneAlmacen(boolean tieneAlmacen) {
        this.tieneAlmacen = tieneAlmacen;
    }

    @Override
    public String getTipoVivienda() {
        return "Local";
    }

    @Override
    public String getResumen() {
        return String.format("%s | Superficie: %.2f m² | Almacén: %s",
                super.getResumen(), superficie,
                tieneAlmacen ? "Sí" : "No");
    }
}
