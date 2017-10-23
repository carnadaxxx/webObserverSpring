package com.webObserver.controllers;

import org.springframework.stereotype.Controller;
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

@Controller
public class inicioController {
    
    @RequestMapping("inicio.asp")
    public ModelAndView inicio() {
    
        ModelAndView mav = new ModelAndView();
        //Aqui va el nombre del *jsp        
        mav.setViewName("home/inicio");
        return mav;
        
    }
    
}
