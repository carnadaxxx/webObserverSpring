package com.webObserver.models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author wcoronado
 */
public class Conectar {
    
    public DriverManagerDataSource conectar() {
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://localhost:3306/testing");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
               
        return dataSource;
    
    }
    
}
