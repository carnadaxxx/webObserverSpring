package com.webObserver.models;

/**
 *
 * @author wilson coronado
 * Aqui tenemos que validar que la URL es correctamente ingresada
 */
public class Sitio {
 
    private int idsitio;
    private String url;
    private String nombre;  

    public Sitio() {
        
    }

    public Sitio(int idsitio, String url, String nombre) {
        this.idsitio = idsitio;
        this.url = url;
        this.nombre = nombre;
    }
    
    public int getIdsitio() {
        return idsitio;
    }

    public void setIdsitio(int idsitio) {
        this.idsitio = idsitio;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sitio{" + "idsitio=" + idsitio + ", url=" + url + ", nombre=" + nombre + '}';
    }
    
}
