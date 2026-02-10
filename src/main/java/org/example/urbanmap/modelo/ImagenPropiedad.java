package org.example.urbanmap.modelo;

public class ImagenPropiedad {
    private int idImagen;
    private String urlImagen;
    
    // Constructor vacío
    public ImagenPropiedad() {
    }
    
    // Constructor completo
    public ImagenPropiedad(int idImagen, String urlImagen) {
        this.idImagen = idImagen;
        this.urlImagen = urlImagen;
    }
    
    // Constructor sin ID (para inserciones)
    public ImagenPropiedad(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
    // Getters y Setters
    public int getIdImagen() {
        return idImagen;
    }
    
    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
    
    public String getUrlImagen() {
        return urlImagen;
    }
    
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
    @Override
    public String toString() {
        return "ImagenPropiedad{" +
                "idImagen=" + idImagen +
                ", urlImagen='" + urlImagen + '\'' +
                '}';
    }
}
