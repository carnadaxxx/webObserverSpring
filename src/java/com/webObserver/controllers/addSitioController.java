package com.webObserver.controllers;

import com.webObserver.models.Sitio;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
   //Esto crea el formulario 
   @RequestMapping(value = "overcomandant/addSitio.asp", method = RequestMethod.GET)
   public ModelAndView addSiteForm() {
       
       return new ModelAndView("admin/addNewSite", "sitio", new Sitio());
   
   }
   
   //Esto crea el resultado del formulario
   @RequestMapping(value = "overcomandant/addSitio.asp", method = RequestMethod.POST)
   public String submitSiteForm(
           Sitio sitio, ModelMap model 
                   ) {
       
       model.addAttribute("url", sitio.getUrl());
       model.addAttribute("nombre", sitio.getNombre());
       model.addAttribute("estado", sitio.getEstado());

       return "admin/exito";
   
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
