package org.example.urbanmap.modelo;

/**
 * Interfaz que define el contrato común para todos los tipos de vivienda.
 * Cualquier tipo de propiedad habitable (Casa, Piso, Local) debe implementar esta interfaz.
 */
public interface Vivienda {

    /**
     * Obtiene el nombre de la vivienda.
     */
    String getNombre();

    /**
     * Obtiene el precio de la vivienda.
     */
    double getPrecio();

    /**
     * Obtiene la descripción de la vivienda.
     */
    String getDescripcion();

    /**
     * Indica si la vivienda está disponible para la venta.
     */
    boolean isDisponible();

    /**
     * Obtiene el tipo de vivienda (Casa, Piso, Local, etc.).
     */
    String getTipoVivienda();

    /**
     * Obtiene la latitud de la ubicación de la vivienda.
     */
    double getLatitud();

    /**
     * Obtiene la longitud de la ubicación de la vivienda.
     */
    double getLongitud();

    /**
     * Devuelve un resumen con la información principal de la vivienda.
     */
    String getResumen();
}
