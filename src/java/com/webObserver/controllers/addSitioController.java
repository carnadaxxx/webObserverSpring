 package com.webObserver.controllers;

import com.webObserver.commons.Conectar;
import com.webObserver.models.Sitio;
import com.webObserver.validators.SitioValidar;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
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
 * Este es el formulario de creacion de sitios web
 * Basicamente este tiene que coexistir con un sistema de subida masiva
 * Si no es probable que lo suva en un solo porrazo atravez de un csv
 * con phpMyAdmin
 *
 */

@Controller
public class addSitioController {
    
    private final SitioValidar sitioValidar;
    private JdbcTemplate jdbcTemplate; 
            

    public addSitioController() {
        this.sitioValidar = new SitioValidar();
        Conectar con = new Conectar(); 
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
   //Esto crea el formulario 
   @RequestMapping(value = "overcomandant/addSitio.asp", method = RequestMethod.GET)
   public ModelAndView addSiteForm(HttpServletRequest request) {
       
       HttpSession newSession = request.getSession();
       
       if(newSession.getAttribute("userSession") != null) {
           
            //return new ModelAndView("admin/addNewSite", "sitio", new Sitio());
            ModelAndView st = new ModelAndView();
            st.setViewName("admin/addNewSite");
            st.addObject("sitio", new Sitio());
       
            return st;
   
           
       } else {
       
           return new ModelAndView("redirect:login.asp");
           
       }

   }
   
   //Esto recibe y valida el resultado del formulario de mas arriva
   @RequestMapping(value = "overcomandant/addSitio.asp", method = RequestMethod.POST)
   public ModelAndView submitSiteForm(@ModelAttribute("sitio") Sitio s, BindingResult result, SessionStatus status, HttpServletRequest request) {
       
        HttpSession newSession = request.getSession();
        
        if(newSession.getAttribute("userSession") != null) {
            
            this.sitioValidar.validate(s, result);
        
            if(result.hasErrors()) {
                //cuando los datos no son correctos
                ModelAndView st = new ModelAndView();
                st.setViewName("admin/addNewSite");
                st.addObject("sitio", new Sitio());

                return st;


            } else {

                this.jdbcTemplate.update(
                "insert into sitio (url,nombre) values (?,?)",
                s.getUrl(),        
                s.getNombre());

                return new ModelAndView("redirect:listSitioAdmin.asp");

                //cuando los datos ingresados son correctos 
                //ModelAndView st = new ModelAndView();
                //st.setViewName("admin/exitoSitio");
                //st.addObject("nombre", s.getNombre());
                //st.addObject("url", s.getUrl());
                //st.addObject("estado", s.getEstado());

                //return st;

            }
            
        
        } else {
            
            return new ModelAndView("redirect:login.asp");
            
        }
       

        
   }
   
    // Metodo para poblar un select
    @ModelAttribute("estadoLista")
    public Map<String,String> ListadoEstados() {
  
        Map<String, String> estado = new LinkedHashMap<>();
        estado.put("1","Activo");
        estado.put("2","Inactivo");
        estado.put("3","Testing");
        
        return estado;
      
    }
          
}
