/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webObserver.validators;

import com.webObserver.models.Usuario;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author wcoronado
 */
public class UsuarioValidar implements Validator {
    
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private Pattern pattern;
    private Matcher matcher;
    
    
    
    @Override
    public boolean supports(Class<?> type) {
        
        return Usuario.class.isAssignableFrom(type);
    
    }
    
    @Override
    public void validate(Object o, Errors errors) {
    
        Usuario usuario = (Usuario)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombres", "required.nombres", "El campo nombres es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "required.apellidos", "El campo apellidos es obligatorio");
    
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "El campo e-mail es obligatorio");
    
        if(!(usuario.getEmail() != null && usuario.getEmail().isEmpty())) {
        
            this.pattern = Pattern.compile(EMAIL_REGEX);
            this.matcher = pattern.matcher(usuario.getEmail());
                if (!matcher.matches()) {
                
                    errors.rejectValue("email", "email.incorrect", "El Email "+ usuario.getEmail() + " no es valido.");
                    
                }
        
        }
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.username", "El campo Nombre de Usuario es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "El campo Contraseña es obligatorio");
        
    }
    
}
