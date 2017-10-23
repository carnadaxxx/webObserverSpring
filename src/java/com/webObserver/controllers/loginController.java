package com.webObserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wilson coronado
 * Este es el controlador del login 
 * cambie el url para evitar que alguien intente llegar al 
 * url del administrado
 */
@Controller
public class loginController {
    
    @RequestMapping("overcomandant/login.asp")
    public ModelAndView login() {
        
        ModelAndView lgn = new ModelAndView();
        lgn.setViewName("admin/login");
        return lgn;
    
    }
    
}
