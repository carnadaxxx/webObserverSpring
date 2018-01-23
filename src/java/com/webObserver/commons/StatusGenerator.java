package com.webObserver.commons;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author wcoronadob
 * Esta clase va a recibir el idsitio 
 * despues consguira el URL
 * y luego Procesara esa url y conseguira el status
 */
public class StatusGenerator {
    
    private final JdbcTemplate jdbcTemplate;
    
    int idsitio;
    
    
    public StatusGenerator(int idsitio) {
    
        this.idsitio = idsitio;
        
        Conectar con = new Conectar();
        
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    
    }
    
    public String URLsite() {
    
        String urlQuery = "SELECT url FROM sitio WHERE idsitio=" + this.idsitio + ";";
    
        
        String urlName = (String) this.jdbcTemplate.queryForObject(
                urlQuery, new Object[] { idsitio }, String.class);
    
        
        return urlName;
    }
    
}
