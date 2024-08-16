package edu.cibertec.cursoseguro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.cursoseguro.entity.UsuarioEntity;
import edu.cibertec.cursoseguro.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/admin/mantenimientousuarios")
    public ModelAndView mantenimientoUsuarios(){
        return  new ModelAndView("/admin/listarUsuarios","listaUsuario",usuarioService.listarUsuario());
    }

    @RequestMapping("admin/eliminarUsuario")
    public ModelAndView eliminarUsuario(Integer idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
        return  new ModelAndView("/admin/listarUsuarios","listaUsuario",usuarioService.listarUsuario());
    }

    @RequestMapping("admin/formularioGrabarUsuario")
    public String formularioGrabarUsuario(){
        return  "/admin/formularioGrabarUsuario";
    }

    @RequestMapping("admin/accionGrabarUsuairo")
    public String accionGrabarUsuairo(UsuarioEntity usuario){
        usuario.setEstado(1);
        usuarioService.crearUsuario(usuario);
        return  "redirect:/admin/mantenimientousuarios";
    }
}
