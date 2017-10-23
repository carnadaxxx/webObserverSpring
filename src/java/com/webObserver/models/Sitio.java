package com.webObserver.models;

/**
 *
 * @author wilson coronado
 * Aqui tenemos que validar que la URL es correctamente ingresada
 */
public class Sitio {
 
    private int id;
    private String url;
    private String nombre;  
    private int estado;

    public Sitio() {
        
    }
    
    public Sitio(String url, String nombre, int estado) {
        this.url = url;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Sitio{" + "id=" + id + ", url=" + url + ", nombre=" + nombre + ", estado=" + estado + '}';
    }

    
    
    
}
