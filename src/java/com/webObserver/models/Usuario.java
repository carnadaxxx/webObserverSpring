package com.webObserver.models;

/**
 *
 * @author wilson coronado
 * Construccion basica de lo que es un Usuario
 */
public class Usuario {
    
    private int id;
    private String nombres;
    private String apellidos;
    private String email;
    
    private String username;
    private String password;

    public Usuario() {
        
    }

    public Usuario(int id, String nombres, String Apellidos, String email ,String username, String password) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = Apellidos;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", Apellidos=" + apellidos + ", email=" + email + ", username=" + username + ", password=" + password + '}';
    }
    
    
    
           
    
}
