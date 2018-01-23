/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webObserver.commons;

import java.util.List;

/**
 *
 * @author wcoronado
 * Esta es la clase que genera las muestras 
 */
public class MuestrasGenerator {


    

    public static void main(String [] args) {
        
        ListSiteGenerator Sc = new ListSiteGenerator();
        
        List datos = Sc.SitioListaGenerador();
        
    
        for (int i = 1; i < datos.size(); i++ ) {

           getUrlFormId gu = new getUrlFormId(i);
           
           System.out.print(gu);
        
        }
        

        
    }
 
}
