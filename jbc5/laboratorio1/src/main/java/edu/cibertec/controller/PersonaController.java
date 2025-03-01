package edu.cibertec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.Persona;

@RestController
@RequestMapping("api/v1/personas")
public class PersonaController {
    private List<Persona> personas = new ArrayList();

    @GetMapping
    public List<Persona> listarPersonas() {        
        personas.add(new Persona("1", "Juan", "Perez", "25", "12345678"));
        personas.add(new Persona("2", "Maria", "Lopez", "30", "87654321"));
        return personas;
    }

    @GetMapping("/{idPersona}")
    public Persona obtenerPersona(@PathVariable("idPersona") String idPersona) {
        return personas.stream().filter(p -> p.getIdPersona().equals(idPersona)).findFirst().orElse(null);
    }

}
