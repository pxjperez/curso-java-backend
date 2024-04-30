/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpere
 */
@RestController
@RequestMapping("usuario")
public class UsuarioRestController {
    @Autowired
    UsuarioService usuarioService;
    @GetMapping("nombreApellido")
    public List<UsuarioEntity>listarUsuariosPorNombreApellido(String nombreApellido){
        return usuarioService.listarUsuarioPorNombreApellido(nombreApellido);
    }
}
