
package com.webObserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wilson Coronado 
 * ESte es el controlador para manejar el dashboard en algunas cosas
 * es para direccionar las funciones principales de la pagina
 * 
 * por lo pronto sera estatico pero con el tiempo.... si esque alcanza tambien
 */

@Controller
public class dashBoardController {
    
    @RequestMapping("overcomandant/dashboard.asp")
    public ModelAndView dashboard() {
    
            ModelAndView dsb = new ModelAndView();
            dsb.setViewName("admin/dashboard");
            
            return dsb;
        
    }
            
    
}
