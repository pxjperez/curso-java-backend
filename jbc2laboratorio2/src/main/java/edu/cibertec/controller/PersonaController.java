/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.bean.Persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpere
 */
@RestController
@RequestMapping("persona")
public class PersonaController {

    private List<Persona> personas;

    @GetMapping
    public List<Persona> listarPersonas() {
        personas = new ArrayList<>();
        personas.add(new Persona("JUAN", "PEREZ GIL", "71583403", "LOS DIAMANTES 1300", new Date()));
        personas.add(new Persona("DANIEL", "DIAZ GIL", "45124563", "LOS PORTALES 1300", new Date()));
        return personas;
    }

}
