package com.webObserver.controllers;

import com.webObserver.commons.Conectar;
import com.webObserver.commons.Paginator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView listSitio(@RequestParam(value="pagina", defaultValue="1") int pagina, Model map,HttpServletRequest request) {
        
        HttpSession newSession = request.getSession();
        
        if(newSession.getAttribute("userSession") != null) {
    
            //String sql = "SELECT * FROM sitio ORDER BY idsitio DESC";

            Paginator Pg = new Paginator("sitio", 5 , pagina);
            
            List datos = Pg.TablaGenerator();
            
            float t = Pg.CountPager();

            ModelAndView mav = new ModelAndView(); 

            mav.addObject("datos" , datos);
            mav.addObject("t", t);
            mav.setViewName("admin/siteListAdmin");
            return mav;
        
        } else {
        
            return new ModelAndView("redirect:login.asp");
        
        }
    
    }
    
    
}
