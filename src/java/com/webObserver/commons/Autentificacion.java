package com.webObserver.commons;


public class Autentificacion {
    
    String username;
    String password;

    public Autentificacion(String username, String password) {
        this.username = username;
        this.password = password;
                 
    }
    
    public boolean UserAtentificacion() {
    
        //String sql = "SELECT * FROM usuario WHERE username='"+ this.username + "' AND psword='" + this.password + "'";
       

        return true;
    }
    
}
