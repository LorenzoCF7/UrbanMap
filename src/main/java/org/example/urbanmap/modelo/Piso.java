package org.example.urbanmap.modelo;

/**
 * Representa un piso (vivienda en edificio de varias plantas).
 * Hereda de Propiedad e implementa Vivienda a través de ella.
 */
public class Piso extends Propiedad {

    private int planta;
    private boolean tieneAscensor;
    private int numHabitaciones;

    public Piso() {
        super();
    }

    public Piso(int idPropiedad, String nombre, int idTipo, double precio,
                double latitud, double longitud, String descripcion, boolean disponible,
                int planta, boolean tieneAscensor, int numHabitaciones) {
        super(idPropiedad, nombre, idTipo, precio, latitud, longitud, descripcion, disponible);
        this.planta = planta;
        this.tieneAscensor = tieneAscensor;
        this.numHabitaciones = numHabitaciones;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public boolean isTieneAscensor() {
        return tieneAscensor;
    }

    public void setTieneAscensor(boolean tieneAscensor) {
        this.tieneAscensor = tieneAscensor;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    @Override
    public String getTipoVivienda() {
        return "Piso";
    }

    @Override
    public String getResumen() {
        return String.format("%s | Planta: %d | Ascensor: %s | Habitaciones: %d",
                super.getResumen(), planta,
                tieneAscensor ? "Sí" : "No",
                numHabitaciones);
    }
}
