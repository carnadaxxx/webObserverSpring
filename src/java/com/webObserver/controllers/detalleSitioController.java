package com.webObserver.controllers;

import com.webObserver.commons.Conectar;
import com.webObserver.models.Sitio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wilson coronado Este es el controlador que manejara la pagina de
 * detalle del sitio Basicamente es una u otra cosa.... La idea esque esto
 * reciva un ID y en base a eso traiga toda la informacion de un sitio La
 * cuestion es ... como mostrar siertas cosas primero sera una tabla despues el
 * resto pues
 *
 */
@Controller
@RequestMapping(value = "detalle/sitio.asp")
public class detalleSitioController {

    private JdbcTemplate jdbcTemplate;

    public detalleSitioController() {

        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());

    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getSiteData(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();
        int idsitio = Integer.parseInt(request.getParameter("idsitio"));
        Sitio datos = this.selectSitio(idsitio);
        List hstry = this.historiaSitio(idsitio);
        
        mav.setViewName("home/detalle");
        mav.addObject("sitio", new Sitio(idsitio, datos.getUrl(), datos.getNombre()));
        mav.addObject("hstry", hstry);
        
        return mav;

    }

    public Sitio selectSitio(int idsitio) {

        final Sitio sitio = new Sitio();
        String qry = "SELECT * FROM sitio WHERE idsitio='" + idsitio + "';";
        return (Sitio) jdbcTemplate.query(
                qry, new ResultSetExtractor<Sitio>() {

            public Sitio extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {

                    sitio.setUrl(rs.getString("url"));
                    sitio.setNombre(rs.getString("nombre"));

                }

                return sitio;
            }
        });

    }

    
    public <Y> List<Y> historiaSitio(int idsitio) {
    
        String query = "SELECT fecha, estado FROM sitio_muestra INNER JOIN muestra ON id_muestra = idmuestra WHERE id_sitio = " 
                + idsitio + ";";
    
    
        List hstry = this.jdbcTemplate.queryForList(query);

        return hstry;

        
    }
    
}
