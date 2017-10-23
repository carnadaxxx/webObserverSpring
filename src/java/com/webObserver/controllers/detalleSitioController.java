package com.webObserver.controllers;

import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wilson coronado
 * Este es el controlador que manejara la pagina de detalle del sitio 
 * Basicamente es una u otra cosa....
 * La idea esque esto reciva un ID y en base a eso traiga toda la informacion
 * de un sitio
 * La cuestion es ... como mostrar siertas cosas 
 * primero sera una tabla despues quien sabe
 * 
 */

@Controller
public class detalleSitioController {
    
    @RequestMapping("detalle.asp")
    public ModelAndView detalleSitio( HttpServletRequest request ) {
    
        ModelAndView dlts = new ModelAndView();
        dlts.setViewName("home/detalle");
        
        String id =  request.getParameter("id");
        
        dlts.addObject("id", id);
        

        return dlts;
        
        
        
    }
    
}
