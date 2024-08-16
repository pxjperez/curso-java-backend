package edu.cibertec.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.apirest.entity.PersonaEntity;
import edu.cibertec.apirest.service.PersonaService;

@RestController
public class ServicioRestController {
    @Autowired
    private PersonaService personaService;
    @RequestMapping("/")
    public String index() {
        return "Hola desde mi primera aplicacion REST";
    }
    @RequestMapping("/listarPersonas")
    public List<PersonaEntity> listarPersonas() {
       return personaService.listarPersonas();
    }
}
