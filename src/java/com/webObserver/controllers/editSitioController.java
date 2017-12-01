package com.webObserver.controllers;

import com.webObserver.commons.Conectar;
import com.webObserver.models.Sitio;
import com.webObserver.validators.SitioValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
 */
@Controller
@RequestMapping(value="overcomandant/editSitio.asp")
public class editSitioController {

    SitioValidar sitioValidar;
    private JdbcTemplate jdbcTemplate;
    
    public editSitioController() {
        
        this.sitioValidar = new SitioValidar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView editSiteForm(HttpServletRequest request) {
        
        HttpSession newSession = request.getSession();
        
        if(newSession.getAttribute("userSession") != null) {
            
            ModelAndView mav = new ModelAndView();
            int idsitio = Integer.parseInt(request.getParameter("idsitio"));
            Sitio datos = this.selectSitio(idsitio);

            mav.setViewName("admin/editSitio");
            mav.addObject("sitio" , new Sitio(idsitio,datos.getUrl(), datos.getNombre()) );

            return mav;
        
        } else {
        
            return new ModelAndView("redirect:login.asp");
        
        }
        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editSitioPost 
        (
            @ModelAttribute("sitio") Sitio s,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
        )
    {
        HttpSession newSession = request.getSession();
        
        if (newSession.getAttribute("userSession") != null) {
            
            this.sitioValidar.validate(s, result);
        
            if(result.hasErrors()){

                ModelAndView mav = new ModelAndView();
                int idsitio = Integer.parseInt(request.getParameter("idsitio"));
                Sitio datos = this.selectSitio(idsitio);

                mav.setViewName("admin/editSitio");
                mav.addObject("sitio" , new Sitio(idsitio ,datos.getUrl(), datos.getNombre()) );

                return mav;            

            } else {

                int idsitio = Integer.parseInt(request.getParameter("idsitio"));
                this.jdbcTemplate.update(

                        "UPDATE sitio "
                    + "SET nombre=?,"
                    + " url=?,"
                    + "WHERE "
                    + "idsitio=? ",

                    s.getNombre(), s.getUrl(), idsitio);

                return new ModelAndView("redirect:listSitioAdmin.asp");

            }
            
        
        } else {
        
            return new ModelAndView("redirect:login.asp");
            
        }
        
    }
    
    
    /* Esta es la parte donde sacamos a la victima 
    *  para ser modificada o ser transformada =) in to a pickle-!!!!
    */
    
    public Sitio selectSitio(int idsitio) {
            
        final Sitio sitio = new Sitio();
        String qry = "SELECT * FROM sitio WHERE idsitio='" + idsitio + "';";
        return (Sitio) jdbcTemplate.query
        (
                qry, new ResultSetExtractor<Sitio>()  
        
            {
            
                public Sitio extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if(rs.next()) {
                    
                    sitio.setUrl(rs.getString("url"));
                    sitio.setNombre(rs.getString("nombre"));

                }
                
                return sitio;
            }            
        });
        
    }
    
}