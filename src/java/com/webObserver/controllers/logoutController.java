/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webObserver.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wcoronado
 * Este es el controlador que maneja la salida de los usuarios
 */

@Controller
public class logoutController {
    
    @RequestMapping("overcomandant/logout.asp")
    public ModelAndView logOut(HttpServletRequest request) {
    
        HttpSession newSession = request.getSession();
        
        if(newSession.getAttribute("userSession") != null) {
            
            newSession.invalidate();
            return new ModelAndView("redirect:login.asp");
            
        } else {
            
          return new ModelAndView("redirect:login.asp");  
          
        }
        
    }
    
}
