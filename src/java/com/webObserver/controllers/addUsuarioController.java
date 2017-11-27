package com.webObserver.controllers;

import com.webObserver.models.Usuario;
import com.webObserver.validators.UsuarioValidar;
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
 * Este es el controlador para ingresar Usuarios 
 */
@Controller
public class addUsuarioController {
    
    private final UsuarioValidar usuarioValidar;

    public addUsuarioController() {
        this.usuarioValidar = new UsuarioValidar();
    }
    
    @RequestMapping(value = "overcomandant/addUsuario.asp", method = RequestMethod.GET )
    public ModelAndView addUsuarioForm(HttpServletRequest request) {
    
        HttpSession newSession = request.getSession();
        
        if(newSession.getAttribute("userSession") != null) {
        
            ModelAndView usr = new ModelAndView();
            usr.setViewName("admin/addNewUsuario");
            usr.addObject("usuario", new Usuario());
        
        return usr;
        
        } else {
        
            return new ModelAndView("redirect:login.asp");
        
        }
                       
    }
    
    @RequestMapping(value = "overcomandant/addUsuario.asp", method = RequestMethod.POST )
    public ModelAndView submitUsuarioForm(@ModelAttribute("usuario") Usuario u, BindingResult result, SessionStatus status, HttpServletRequest request) {
  
        HttpSession newSession = request.getSession();
        
        if(newSession.getAttribute("userSession") != null) {
            
            this.usuarioValidar.validate(u, result);

            if(result.hasErrors()) {

                ModelAndView usr = new ModelAndView();
                usr.setViewName("admin/addNewUsuario");
                usr.addObject("usuario", new Usuario());

                return usr;

            } else {

                ModelAndView usr = new ModelAndView();
                usr.setViewName("admin/exitoUsr");
                usr.addObject("nombres", u.getNombres());
                usr.addObject("apellidos", u.getApellidos());
                usr.addObject("email", u.getEmail());
                usr.addObject("username", u.getUsername());
                usr.addObject("password", u.getPassword());

                return usr;

            }
        
        
        } else {
        
            return new ModelAndView("redirect:login.asp");
            
        }
        
        
        
    }
    
}
