package org.example.urbanmap.modelo;

/**
 * Modelo que representa una imagen asociada a una propiedad.
 * Corresponde a la tabla 'imagen_propiedad' de la base de datos.
 */
public class ImagenPropiedad {

    private int idImagen;
    private int idPropiedad;
    private String urlImagen;

    public ImagenPropiedad() {
    }

    public ImagenPropiedad(int idImagen, int idPropiedad, String urlImagen) {
        this.idImagen = idImagen;
        this.idPropiedad = idPropiedad;
        this.urlImagen = urlImagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public String toString() {
        return String.format("ImagenPropiedad[id=%d, propiedad=%d, url='%s']",
                idImagen, idPropiedad, urlImagen);
    }
}
