/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
public class UsuarioController {

    @Autowired //usuarioService= new UsuarioServiceImp();
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("accionLogin")
    public ModelAndView accionLogin(UsuarioEntity usuario) {
        ModelAndView mv = new ModelAndView();
        usuario = usuarioService.validarUsuario(usuario);
        if (usuario == null) {
            mv.setViewName("login");
            mv.addObject("msgError", "Usuario o contraseña invalidos");
        } else {
            mv.setViewName("redirect:paginaPrincipal?usuario=" + usuario.getNombreCompleto());
        }
        return mv;
    }

    @RequestMapping("paginaPrincipal")
    public ModelAndView paginaPrincipal(@RequestParam("usuario") String usuario) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("paginaPrincipal");
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping("mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuarios() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mantenimientoUsuarios");
        mv.addObject("listaUsuarios", usuarioService.listarUsuario());
        return mv;
    }

    @RequestMapping("formularioNuevoUsuario")
    public ModelAndView formularioNuevoUsuario() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuarioBean", new UsuarioEntity());
        mv.setViewName("formularioNuevoUsuario");
        return mv;
    }

    @RequestMapping("grabarUsuario")
    public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean") UsuarioEntity usuario, BindingResult resultadoValidacion) {
        ModelAndView mv = new ModelAndView();
        try {
            if (resultadoValidacion.hasErrors()) {
                mv.setViewName("formularioNuevoUsuario");
                mv.addObject("usuarioBean", usuario);
            }else{
                Integer registos = usuarioService.insertarUsuario(usuario);
                if (registos > 0) {
                    mv.setViewName("redirect:mantenimientoUsuarios");
                } else {
                    mv.setViewName("formularioNuevoUsuario");
                    mv.addObject("usuarioBean", usuario);
                }
            }
        } catch (Exception ex) {
            mv.setViewName("formularioNuevoUsuario");
            mv.addObject("usuarioBean", usuario);
            mv.addObject("msgError", "Ocurrio un error al registrar lo datos intentelo nuevamente");
        }
        return mv;
    }

    @RequestMapping("eliminarUsuario")
    public ModelAndView eliminarUsuario(Integer idUsuario) {
        ModelAndView mv = new ModelAndView();
        try {
            usuarioService.eliminarUsuario(idUsuario);
            mv.setViewName("redirect:mantenimientoUsuarios");
        } catch (Exception ex) {
            mv.setViewName("mantenimientoUsuarios");
            mv.addObject("listaUsuarios", usuarioService.listarUsuario());
            mv.addObject("msgError", "No se puedo eliminar");
        }

        return mv;
    }

}
