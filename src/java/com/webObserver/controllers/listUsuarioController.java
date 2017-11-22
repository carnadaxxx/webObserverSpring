package com.webObserver.controllers;

import com.webObserver.commons.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wcoronado
 * Esta es la lista de Usuarios.
 */
public class listUsuarioController {
    
    private final JdbcTemplate jdbcTemplate;
    
    public listUsuarioController() {
        Conectar con = new Conectar();
                
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping("overcomandant/listUsuarioAdmin.asp")
    public ModelAndView listUsuatio() {
    
        String sql = "SELECT * FROM usuario ORDER BY idusuario DESC";
       
        List datos = this.jdbcTemplate.queryForList(sql);
        
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("datos", datos);
        mav.setViewName("admin/usuarioListAdmin");
        
        return mav;
    }
    
}
