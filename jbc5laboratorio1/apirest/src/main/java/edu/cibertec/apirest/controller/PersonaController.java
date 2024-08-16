package edu.cibertec.apirest.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.apirest.entity.PersonaEntity;
import edu.cibertec.apirest.service.PersonaService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value="/api/v1/personas",produces=MediaType.APPLICATION_JSON_VALUE) //AccessPoint
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    //@RequestMapping(method="GET")
    @GetMapping(value="/xml",produces=MediaType.APPLICATION_XML_VALUE) //EndPoint
    public List<PersonaEntity> listarPersonasXml() {
        return personaService.listarPersonas();
    }

    @GetMapping
    public List<PersonaEntity> listarPersonas() {
        return personaService.listarPersonas();
    }

    @GetMapping("/{codigo}")
    public PersonaEntity obtenerPersona(@PathVariable("codigo")Integer codigo) {
        return personaService.obtenerPersona(codigo);
    }

    @PostMapping
    public PersonaEntity registrarPersona(@RequestBody PersonaEntity personaEntity) {
        return personaService.registrarPersona(personaEntity);
    }

    @PutMapping("/{codigo}")
    public PersonaEntity actualizar(@PathVariable("codigo")Integer codigo, PersonaEntity personaEntity) {
        personaEntity.setCodigo(codigo);
        return personaService.actualizarPersona(personaEntity);
    }

    @DeleteMapping("/{codigo}")
    public void eliminarPersona(@PathVariable("codigo")Integer codigo) {
        personaService.eliminarPersona(codigo);
    }

}
