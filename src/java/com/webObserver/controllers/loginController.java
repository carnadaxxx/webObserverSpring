package com.webObserver.controllers;

import com.webObserver.models.Usuario;
import com.webObserver.commons.Autentificacion;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
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
    
    @RequestMapping(value="overcomandant/login.asp", method = RequestMethod.GET)
    public ModelAndView loginForm(@ModelAttribute("usuario") Usuario u, BindingResult result, HttpServletRequest request, HttpSession session, SessionStatus status) {
     
        String username = u.getUsername();
        String password = u.getPassword();
        
        Autentificacion Au = new Autentificacion(username, password);
        Au.UserAtentificacion();
        
        if(Au.UserAtentificacion() == true) {
            session.invalidate();
            HttpSession newSession = request.getSession();
            newSession.setAttribute("userSession", Au);            
            
            return new ModelAndView("redirect:dashboard.asp");
        }    
        else {
                    
            ModelAndView lgn = new ModelAndView();
            lgn.setViewName("admin/login");
            return lgn;
        }
        

    } 

}
