package edu.cibertec.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.cibertec.curso.entity.UsuarioEntity;
import edu.cibertec.curso.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(name = "Usuario", description = "Api Usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> listarUsuarios(){
        List<UsuarioEntity> listarUsuario = usuarioService.listarUsuarios();
        listarUsuario.forEach(u->u.add(linkTo(methodOn(UsuarioController.class).obtenerUsuario(u.getIdUsuario())).withRel("usuario")));
        return listarUsuario;
    }

    @GetMapping("/{idUsuario}")
    //Por defecto el codigo de respuesta exitoso es status code 200
    public UsuarioEntity obtenerUsuario(@PathVariable("idUsuario") Integer idUsuario){
        try{
            UsuarioEntity resultado = usuarioService.obtenerUsuario(idUsuario);
            resultado.add(linkTo(methodOn(UsuarioController.class).obtenerUsuario(idUsuario)).withSelfRel());
            return resultado;
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado",ex);
        }
    }
    
}
