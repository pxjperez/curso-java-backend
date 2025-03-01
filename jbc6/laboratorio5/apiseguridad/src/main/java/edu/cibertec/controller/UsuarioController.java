package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private  UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("{idUsuario}")
    public UsuarioEntity obtenerUsuario(@PathVariable Integer idUsuario) {
        return usuarioService.obtenerUsuario(idUsuario);
    }
}
