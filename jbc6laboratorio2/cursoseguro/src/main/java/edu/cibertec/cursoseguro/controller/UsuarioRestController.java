package edu.cibertec.cursoseguro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.cursoseguro.entity.UsuarioEntity;
import edu.cibertec.cursoseguro.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioService.listarUsuario();
    }
    
    @PostMapping("/autenticar")
    public String Autenticar (String user, String password){
        if (user.equals("admin") && password.equals("admin")){
            return "1";
        } else {
            return "0";
        }
    }
}
