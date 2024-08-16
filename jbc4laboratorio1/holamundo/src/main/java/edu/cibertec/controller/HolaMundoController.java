package edu.cibertec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {
    @RequestMapping("/holaMundo")
    public String holaMundo(){
        return "Hola Mundo desde spring boot";
    }
}
