package org.example.urbanmap.modelo;

import java.time.LocalDate;

public class Compra {
    private int idCompra;
    private int idUsuarioCompra;
    private int idPropiedadCompra;
    private LocalDate fechaCompra;
    
    // Constructor vacío
    public Compra() {
    }
    
    // Constructor completo
    public Compra(int idCompra, int idUsuarioCompra, int idPropiedadCompra, LocalDate fechaCompra) {
        this.idCompra = idCompra;
        this.idUsuarioCompra = idUsuarioCompra;
        this.idPropiedadCompra = idPropiedadCompra;
        this.fechaCompra = fechaCompra;
    }
    
    // Constructor sin ID (para inserciones)
    public Compra(int idUsuarioCompra, int idPropiedadCompra, LocalDate fechaCompra) {
        this.idUsuarioCompra = idUsuarioCompra;
        this.idPropiedadCompra = idPropiedadCompra;
        this.fechaCompra = fechaCompra;
    }
    
    // Getters y Setters
    public int getIdCompra() {
        return idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    
    public int getIdUsuarioCompra() {
        return idUsuarioCompra;
    }
    
    public void setIdUsuarioCompra(int idUsuarioCompra) {
        this.idUsuarioCompra = idUsuarioCompra;
    }
    
    public int getIdPropiedadCompra() {
        return idPropiedadCompra;
    }
    
    public void setIdPropiedadCompra(int idPropiedadCompra) {
        this.idPropiedadCompra = idPropiedadCompra;
    }
    
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    @Override
    public String toString() {
        return "Compra{" +
                "idCompra=" + idCompra +
                ", idUsuarioCompra=" + idUsuarioCompra +
                ", idPropiedadCompra=" + idPropiedadCompra +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}
