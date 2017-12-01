package com.webObserver.JSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author wcoronado
 */

@Controller
@RequestMapping(value="/result")
public class inicioSerializer {
    
    @RequestMapping(value="/helloajax", method = RequestMethod.POST)
    @ResponseBody
    public String helloajax() {
    
        return "Hola ajax";
    
    }
    
    
}
