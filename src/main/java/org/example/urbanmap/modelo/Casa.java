package org.example.urbanmap.modelo;

/**
 * Representa una casa (vivienda unifamiliar).
 * Hereda de Propiedad e implementa Vivienda a través de ella.
 */
public class Casa extends Propiedad {

    private int numPlantas;
    private boolean tieneJardin;
    private boolean tieneGaraje;

    public Casa() {
        super();
    }

    public Casa(int idPropiedad, String nombre, int idTipo, double precio,
                double latitud, double longitud, String descripcion, boolean disponible,
                int numPlantas, boolean tieneJardin, boolean tieneGaraje) {
        super(idPropiedad, nombre, idTipo, precio, latitud, longitud, descripcion, disponible);
        this.numPlantas = numPlantas;
        this.tieneJardin = tieneJardin;
        this.tieneGaraje = tieneGaraje;
    }

    public int getNumPlantas() {
        return numPlantas;
    }

    public void setNumPlantas(int numPlantas) {
        this.numPlantas = numPlantas;
    }

    public boolean isTieneJardin() {
        return tieneJardin;
    }

    public void setTieneJardin(boolean tieneJardin) {
        this.tieneJardin = tieneJardin;
    }

    public boolean isTieneGaraje() {
        return tieneGaraje;
    }

    public void setTieneGaraje(boolean tieneGaraje) {
        this.tieneGaraje = tieneGaraje;
    }

    @Override
    public String getTipoVivienda() {
        return "Casa";
    }

    @Override
    public String getResumen() {
        return String.format("%s | Plantas: %d | Jardín: %s | Garaje: %s",
                super.getResumen(), numPlantas,
                tieneJardin ? "Sí" : "No",
                tieneGaraje ? "Sí" : "No");
    }
}
