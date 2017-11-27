package com.webObserver.controllers;

import com.webObserver.commons.Conectar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public ModelAndView listUsuatio(HttpServletRequest request) {
        
        HttpSession newSession = request.getSession();
        
        if(newSession.getAttribute("userSession") != null ) {
        
            String sql = "SELECT * FROM usuario ORDER BY idusuario DESC";
       
            List datos = this.jdbcTemplate.queryForList(sql);

            ModelAndView mav = new ModelAndView();

            mav.addObject("datos", datos);
            mav.setViewName("admin/usuarioListAdmin");

            return mav;
        
        } else {
        
            return new ModelAndView("redirect:login.asp");
        
        }
        
    }
    
}
