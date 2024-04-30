package edu.cibertec.rest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ServicioRestController {
    @RequestMapping("/")
    public String index() {
        return "HOLA MUNDO";
    }   
    
}
