package edu.cibertec.matricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.matricula.entity.UsuarioEntity;
import edu.cibertec.matricula.service.UsuarioService;

@RestController
@RequestMapping("personas")
public class PersonasController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public List<UsuarioEntity> listarPersonas() {
        return usuarioService.listarUsuarios();
    }
    
}
