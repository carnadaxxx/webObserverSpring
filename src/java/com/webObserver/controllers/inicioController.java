package com.webObserver.controllers;

import com.webObserver.commons.Conectar;
import com.webObserver.commons.Paginator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView inicio(@RequestParam(value="pagina", defaultValue="1") int pagina, Model map) {
            
        Paginator Pg = new Paginator("sitio", 5 , pagina);
       
        List datos = Pg.TablaGenerator();
        float t = Pg.CountPager();
     
        
        ModelAndView mav = new ModelAndView(); 
        mav.addObject("datos" , datos);
        mav.addObject("t", t);
        mav.setViewName("home/inicio");
        return mav;
        
    }
    
}