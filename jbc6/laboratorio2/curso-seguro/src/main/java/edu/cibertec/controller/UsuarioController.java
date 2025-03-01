package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;

@Controller
public class UsuarioController {
    @Autowired
    private  UsuarioService usuarioService;

    @RequestMapping("/admin/mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuarios() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listaUsuarios", usuarioService.listarUsuarios());
        modelAndView.setViewName("admin/mantenimientoUsuarios");
        return modelAndView;
    }

    @RequestMapping("/admin/registrarUsuario")
    public ModelAndView registrarUsuario(UsuarioEntity usuario) {
        ModelAndView modelAndView = new ModelAndView();
        usuario.setEstado(1);
        usuario = usuarioService.registrarUsuario(usuario);
        if(usuario!=null){
            modelAndView.addObject("mensaje", "Usuario registrado correctamente");
        }else{
            modelAndView.addObject("mensaje", "Error al registrar usuario");
        }  
        modelAndView.setViewName("/admin/mantenimientoUsuarios");
        modelAndView.addObject("listaUsuarios", usuarioService.listarUsuarios());
        return modelAndView;
    }
}
