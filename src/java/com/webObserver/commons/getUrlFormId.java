/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webObserver.commons;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author wcoronadob
 */
class getUrlFormId {
    
    int idSitio;
    
    private final JdbcTemplate jdbcTemplate;
    
    public getUrlFormId(int idSitio) {
        
        this.idSitio = idSitio;
    
        Conectar con = new Conectar();

        this.jdbcTemplate = new JdbcTemplate(con.conectar());   
    
    }


    
    public String getUrlFormId() {
        
        String query = "SELECT url FROM sitio WHERE idsitio=" + idSitio + ";";
        
        String resultado = (String) this.jdbcTemplate.queryForObject(query, String.class);

        return  resultado;

    
    }
    
    
}
