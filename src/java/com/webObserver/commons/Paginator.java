package com.webObserver.commons;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author wilson coronado Esta clase se encargaria de generar las tablas con
 * paginador deberia recibir el nombre de la tabla y el numero de elementos por
 * pagina
 * 
 * y Genera el numero de elementos por pagina.
 *
 */
public class Paginator {

    private final JdbcTemplate jdbcTemplate;

    /*este es el nombre de la tabla*/
    String tablaNombre;
    
    /*Numero de objetos que van en cada pagina*/
    int numeroPaginas;
    
    /*Numero de orden de la pagina*/
    int paginas;
    
    public Paginator(String tablaNombre, int numeroPaginas, int paginas) {

        this.tablaNombre = tablaNombre;
        
        /*Numero de registros por pagina*/
        this.numeroPaginas = numeroPaginas;
        
        /*El identificador de la Pagina*/
        this.paginas = paginas;

        Conectar con = new Conectar();

        this.jdbcTemplate = new JdbcTemplate(con.conectar());

    }


    /* Contador*/
    public float CountPager() {

        String counter = "SELECT COUNT(*) FROM " + this.tablaNombre + ";";

        float numeroElementos = this.jdbcTemplate.queryForInt(counter);

        float numPag = numeroElementos / this.numeroPaginas;

        if (numPag % 2 == 0) {

            return numPag;

        } else {
            
            return (int)Math.ceil(numPag);

        }

    }

    /*Generador de lista*/
    public <T> List<T> TablaGenerator() {
        
        if(this.paginas == 0 && this.paginas > this.CountPager()) {
            this.paginas = 1;
        } 
        
        int inicioPagina = ((this.paginas - 1 ) * this.numeroPaginas) + 1;
        int finalPagina = (inicioPagina + this.numeroPaginas)-1;
        
        String query = "SELECT * FROM "
                + this.tablaNombre + 
                " WHERE id" 
                + this.tablaNombre +
                " BETWEEN " 
                + inicioPagina +
                " AND "
                + finalPagina + 
                ";"
                ;
        
        List resultado = this.jdbcTemplate.queryForList(query);

        return resultado;

    }    

}
