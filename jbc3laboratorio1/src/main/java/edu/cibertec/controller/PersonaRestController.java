/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@RestController
@RequestMapping("/personas")
public class PersonaRestController {    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public List<UsuarioEntity> mantenimientoUsuarios() {
        return usuarioService.listarUsuario();
    }
    @GetMapping("/session")
    public String nombreUsuarioSession(HttpServletRequest request) {
        return request.getSession().getAttribute("usuario").toString();
    }
}
