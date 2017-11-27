package com.webObserver.controllers;

import com.webObserver.commons.Conectar;
import com.webObserver.models.Sitio;
import com.webObserver.validators.SitioValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
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
            int id = Integer.parseInt(request.getParameter("id"));
            Sitio datos = this.selectSitio(id);

            mav.setViewName("admin/editSitio");
            mav.addObject("sitio" , new Sitio(id,datos.getUrl(), datos.getNombre(), datos.getEstado()) );

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
                int id = Integer.parseInt(request.getParameter("id"));
                Sitio datos = this.selectSitio(id);

                mav.setViewName("admin/editSitio");
                mav.addObject("sitio" , new Sitio(id,datos.getUrl(), datos.getNombre(), datos.getEstado()) );

                return mav;            

            } else {

                int id = Integer.parseInt(request.getParameter("id"));
                this.jdbcTemplate.update(

                        "UPDATE sitio "
                    + "SET nombre=?,"
                    + " url=?,"
                    + " estado=? "
                    + "WHERE "
                    + "id=? ",

                    s.getNombre(), s.getUrl(), s.getEstado(), id);

                return new ModelAndView("redirect:listSitioAdmin.asp");

            }
            
        
        } else {
        
            return new ModelAndView("redirect:login.asp");
            
        }
        
    }
    
    
    /* Esta es la parte donde sacamos a la victima 
    *  para ser modificada o ser transformada =) in to a pickle-!!!!
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
