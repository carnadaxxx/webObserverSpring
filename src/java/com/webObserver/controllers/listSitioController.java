package com.webObserver.controllers;

import com.webObserver.commons.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wilson coronado barrantes
 * Este es el controlador que maneja la lista de Sitios para el administrador
 * 
 */
public class listSitioController {
    
    private final JdbcTemplate jdbcTemplate;

    public listSitioController() {
        Conectar con = new Conectar();
        
        this.jdbcTemplate = new JdbcTemplate(con.conectar()); 
    }
    
    @RequestMapping("overcomandant/listSitioAdmin.asp")
    public ModelAndView listSitio() {
    
        String sql = "SELECT * FROM sitio ORDER BY ID DESC";
        
        List datos = this.jdbcTemplate.queryForList(sql);

        ModelAndView mav = new ModelAndView(); 
        
        mav.addObject("datos" , datos);
        mav.setViewName("admin/siteListAdmin");
        return mav;
    
    }
    
    
}
