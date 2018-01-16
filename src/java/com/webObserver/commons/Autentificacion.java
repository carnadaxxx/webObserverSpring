package com.webObserver.commons;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author Wilson Coronado 
 * Este es el componente que maneja la autentificacion de los usuarios con la base de datos
 * 
 * Recibe el nombre de usuario y la contraseña y lo compara con la base de datos
 * falta fortaleser esta clase.
 */

public class Autentificacion {
    
    private final JdbcTemplate jdbcTemplate;
    
    String username;
    String password;
    
    public Autentificacion(String username, String password) {
        this.username = username;
        this.password = password;
                 
        Conectar con = new Conectar();
        
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    
    }   
    
    public boolean UserAtentificacion() {
    
        String sql = "SELECT * FROM usuario WHERE username='"
                + this.username + 
                "' AND psword='" 
                + this.password + "'";
       
        List usuario = this.jdbcTemplate.queryForList(sql);
                
        if(usuario.isEmpty()) {
            
            return false;
            
        } else {
            
            return true;
        }        
        
    }
    
}
