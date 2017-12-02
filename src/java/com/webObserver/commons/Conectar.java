package com.webObserver.commons;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author wilson coronado  
 * esta es la calse que se encarga de la coneccion de la Base de datos
 * Estamos usando mariaDB
 */
public class Conectar {
    
    public DriverManagerDataSource conectar() {
        
        String Server = "192.168.8.100";
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://" + Server +  "/webObserverDB");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
               
        return dataSource;
    
    }
    
}
