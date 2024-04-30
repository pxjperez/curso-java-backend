package edu.cibertec.matricula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.matricula.entity.UsuarioEntity;
import edu.cibertec.matricula.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping("/")
    public String mostrarLogin(){
        return "login";
    }
    @PostMapping("login")
    public ModelAndView login(UsuarioEntity usuario) {
        ModelAndView mv = new ModelAndView();
        usuario =usuarioService.autenticar(usuario);
        if(usuario!=null){
            mv.setViewName("principal");
            mv.addObject("mensaje", "Bienvendio "+usuario.getUsuario());
        }else{
            mv.setViewName("login");
            mv.addObject("msgError", "Usuario o contraseña incorrectos");
        }
        return mv;
    }
    
}
