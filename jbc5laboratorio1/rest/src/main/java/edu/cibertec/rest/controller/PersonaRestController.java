package edu.cibertec.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.rest.entity.PersonaEntity;
import edu.cibertec.rest.service.PersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value="api/v2/personas", produces=MediaType.APPLICATION_JSON_VALUE)
public class PersonaRestController {

    @Autowired
    private PersonaService personaService;

    @GetMapping()
    public List<PersonaEntity> listarPersonas() {
        return personaService.listarPersonas();
    }

    @GetMapping("/{idPersona}")
    public PersonaEntity obtenerPersonaJson(@PathVariable("idPersona") Integer idPersona) {
        return personaService.obtenerPersona(idPersona);
    }

    @GetMapping(value = "/xml/{idPersona}", produces=MediaType.APPLICATION_XML_VALUE)
    public PersonaEntity obtenerPersonaXML(@PathVariable("idPersona") Integer idPersona) {
        return personaService.obtenerPersona(idPersona);
    }
    
}
