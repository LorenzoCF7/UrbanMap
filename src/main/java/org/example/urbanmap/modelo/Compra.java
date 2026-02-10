package org.example.urbanmap.modelo;

import java.time.LocalDate;

/**
 * Modelo que representa una compra de propiedad.
 * Corresponde a la tabla 'compra' de la base de datos.
 */
public class Compra {

    private int idCompra;
    private int idUsuarioCompra;
    private int idPropiedadCompra;
    private LocalDate fechaCompra;

    // Referencias opcionales a objetos completos
    private Usuario usuario;
    private Propiedad propiedad;

    public Compra() {
    }

    public Compra(int idCompra, int idUsuarioCompra, int idPropiedadCompra, LocalDate fechaCompra) {
        this.idCompra = idCompra;
        this.idUsuarioCompra = idUsuarioCompra;
        this.idPropiedadCompra = idPropiedadCompra;
        this.fechaCompra = fechaCompra;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    @Override
    public String toString() {
        return String.format("Compra[id=%d, usuario=%d, propiedad=%d, fecha=%s]",
                idCompra, idUsuarioCompra, idPropiedadCompra, fechaCompra);
    }
}
