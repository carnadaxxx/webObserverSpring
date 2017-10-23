/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webObserver.models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author wcoronado
 * Esto es el Validator para Sitio
 */
public class SitioValidar implements Validator {
    
    @Override
    public boolean supports(Class<?> type) {
        
        return Sitio.class.isAssignableFrom(type);
    
    }
    
    @Override
    public void validate(Object o, Errors errors) {
    
        Sitio sitio = (Sitio)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, 
                "url", 
                "required.url",
                "El campo Url es obligatorio"
        );
        
    }
    
    
}
