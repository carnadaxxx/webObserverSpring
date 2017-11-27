/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webObserver.validators;

import com.webObserver.models.Usuario;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author wcoronado
 * Esta clase es para realizar las validaciones del formulario de logueo desde
 * el servidor
 */
public class LoginValidar implements Validator {
 
    @Override
    public boolean supports(Class<?> type) {
        
        return Usuario.class.isAssignableFrom(type);
    
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        Usuario usuario = (Usuario)o;
        String errorUsernamer = "El campo Usuario es obligatorio.";
        String errorPassword = "El campo Contraseña es obligatario.";
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username" ,"required.username", errorUsernamer);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password" ,"required.password", errorPassword);        
   
    }
    
    
}
