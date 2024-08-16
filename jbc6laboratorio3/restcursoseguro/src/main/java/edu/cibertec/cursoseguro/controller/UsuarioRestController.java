package edu.cibertec.cursoseguro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.cursoseguro.entity.UsuarioEntity;
import edu.cibertec.cursoseguro.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioService.listarUsuario();
    }


    @GetMapping("{idUsuario}")
    public UsuarioEntity obtenerUsuario(@PathVariable("idUsuario") Integer idCurso){
        return usuarioService.obtenerUsuario(idCurso);
    }
    
    @PostMapping("/autenticar")
    public UsuarioEntity Autenticar (String user, String password){
        return usuarioService.autenticar(user, password);
    }
}
