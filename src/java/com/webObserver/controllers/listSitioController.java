/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webObserver.controllers;

import com.webObserver.models.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wcoronado
 */
public class listSitioController {
    
    private final JdbcTemplate jdbcTemplate;

    public listSitioController() {
        Conectar con = new Conectar();
        
        this.jdbcTemplate = new JdbcTemplate(con.conectar()); 
    }
    
    @RequestMapping("overcomandant/listSitioAdmin.asp")
    public ModelAndView listSitio() {
    
        String sql = "SELECT * FROM sitio ORDER BY ID DESC";
        
        List datos = this.jdbcTemplate.queryForList(sql);
    
        ModelAndView mav = new ModelAndView(); 
        
        mav.addObject("datos" , datos);
        mav.setViewName("admin/siteListAdmin");
        return mav;
    
    }
    
    
}
