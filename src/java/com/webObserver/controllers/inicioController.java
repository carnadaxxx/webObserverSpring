package com.webObserver.controllers;

import com.webObserver.models.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wilson coronado
 * Este es el controlador que manejara el inicio de la pagina
 * EL inicio esta compuesto por una tabla que lista todas las paginas
 * del estado.
 * 
 * Junto con un filtro y una tabla con paginacion 
 */


public class inicioController {
    
    private JdbcTemplate jdbcTemplate;

    public inicioController() {
        
        Conectar con = new Conectar();
        
        this.jdbcTemplate = new JdbcTemplate(con.conectar()); 
         
    }
    
     
    @RequestMapping("inicio.asp")
    public ModelAndView inicio() {
        
        String sql = "SELECT * FROM sitio";
        
        List datos = this.jdbcTemplate.queryForList(sql);
        
        
    
        ModelAndView mav = new ModelAndView(); 
        
        mav.addObject("datos" , datos);
        mav.setViewName("home/inicio");
        return mav;
        
    }
    
}
