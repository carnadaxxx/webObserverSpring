package com.webObserver.controllers;

import com.webObserver.models.Conectar;
import com.webObserver.models.Sitio;
import com.webObserver.validators.SitioValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wilson coronado
 */
@Controller

public class editSitioController {

    SitioValidar sitioValidar;
    private JdbcTemplate jdbcTemplate;
    
    public editSitioController() {
        
        this.sitioValidar = new SitioValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    
    }
    
    @RequestMapping(value="overcomandant/editSitio.asp", method = RequestMethod.GET)
    public ModelAndView editSiteForm(HttpServletRequest request) {
    
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Sitio datos = this.selectSitio(id);
        
        mav.setViewName("admin/editSitio");
        mav.addObject("sitio" , new Sitio(id,datos.getUrl(), datos.getNombre(), datos.getEstado()) );
        
        return mav;
        
    }
    
    
    /* Esta es la parte donde sacamos a la victima 
    *para ser modificada o ser transformada =) in to a pickle-!!!!
    */
    
    public Sitio selectSitio(int id) {
    
        
        final Sitio sitio = new Sitio();
        String qry = "SELECT * FROM sitio WHERE id='" + id + "';";
        return (Sitio) jdbcTemplate.query
        (
                qry, new ResultSetExtractor<Sitio>()  
        
            {
            
                public Sitio extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if(rs.next()) {
                    
                    sitio.setUrl(rs.getString("url"));
                    sitio.setNombre(rs.getString("nombre"));
                    sitio.setEstado(rs.getInt("estado"));

                }
                
                return sitio;
        
            }            
        });
        
    }
    
    
}
