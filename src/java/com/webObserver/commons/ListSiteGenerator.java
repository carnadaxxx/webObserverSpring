package com.webObserver.commons;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author wilson coronado
 * Esta clase es la que recoge el estado http recibe la url
 */
public class ListSiteGenerator {
    
    private JdbcTemplate jdbcTemplate; 
    
    public ListSiteGenerator() {
        
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    
    }

    
    public <T> List<T>  SitioListaGenerador() {
        
        String query = "SELECT idsitio, url FROM sitio;";
        
        List resultado = this.jdbcTemplate.queryForList(query);
        
        return resultado;
    
    }
    

    
}
