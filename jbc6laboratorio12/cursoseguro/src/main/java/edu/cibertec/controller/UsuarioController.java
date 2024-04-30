package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;

@Controller
public class UsuarioController {

    
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error ) {
        if(error!=null){
            return  new ModelAndView("login","error","Usuario o contraseña incorrectos");
        }  else{
            return  new ModelAndView("login");
        }
        
    }

    @RequestMapping("/")
    public String principal() {
        return "principal";
    }

    @RequestMapping("listarUsuarios")
    public String listarUsuario(Model model) {
        model.addAttribute("listaUsuario", usuarioService.listarUsuarios());
        return "listarUsuarios";
    }

    @RequestMapping("formularioGrabarUsuario")
    public String formularioGrabarUsuario() {
        return "formularioGrabarUsuario";
    }

    @RequestMapping("accionGrabarUsuairo")
    public String accionGrabarUsuairo(UsuarioEntity usuario) {        
        usuarioService.crearUsuario(usuario);
        return "redirect:listarUsuarios";
    }
    
}
