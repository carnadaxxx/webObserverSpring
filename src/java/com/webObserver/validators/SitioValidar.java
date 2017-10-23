package com.webObserver.validators;

import com.webObserver.models.Sitio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author wcoronado
 * Esto es el Validator para Sitio
 * es decir aqui van a ir todas las reglas de validacion 
 * desde el servidor
 */
public class SitioValidar implements Validator {
    
    //Esto va a cambiar para que solo acepte sitios .gov.pe
    private static final String URL_REGEX = "^[a-zA-Z0-9\\-\\.]+\\.(com|org|net|mil|edu|COM|ORG|NET|MIL|EDU)$";
    
    private Pattern pattern;
    private Matcher matcher;
    
    
    @Override
    public boolean supports(Class<?> type) {
        
        return Sitio.class.isAssignableFrom(type);
    
    }
    
    @Override
    public void validate(Object o, Errors errors) {
    
        //Este es el objeto 
        Sitio sitio = (Sitio)o;
        //Nombre obligatorio
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",  "required.nombre", "El campo nombre es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url", "required.url", "El campo Url es obligatorio");
        


        //Valida si el valor de estado es = 0
        //Esta validacion me servira cuando implemente el muestreo de las paginas
        if(!(sitio.getEstado() != 0 )) {  
            errors.rejectValue("estado", "estado.incorrect", "Tienes que escojer un estado" ); 
        } 
        
        //Validacion si el Url es una pagina adecuada
        //Podria usar un meetodo nativo de Spring pero tengo que validar que solo tenga .gov.pe
        if(!(sitio.getUrl() != null && sitio.getUrl().isEmpty())) {
        
            this.pattern = Pattern.compile(URL_REGEX);
            this.matcher = pattern.matcher(sitio.getUrl());
                if (!matcher.matches()) {
                
                    errors.rejectValue("url", "url.incorrect", "El Url "+ sitio.getUrl() + " no es valido.");
                    
                }
        
        }
    
    }
    
    
}
