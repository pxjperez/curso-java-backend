package edu.cibertec.matricula.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.matricula.entity.UsuarioEntity;
import edu.cibertec.matricula.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("actionLogin") 
    public ModelAndView actionLogin(String user, String password){
        ModelAndView mv = new ModelAndView();
        UsuarioEntity usuario =usuarioService.autenticar(user, password);
        if(usuario==null){
            mv.setViewName("login");
            mv.addObject("mensajeError", "Usuario y/o contraseña incorrectos");
        }else{
            mv.setViewName("paginaPrincipal");
            mv.addObject("usuario", usuario.getNombreCompleto());
            mv.addObject("mensaje", new String(mensajeBienvenida.getBytes(), StandardCharsets.UTF_8)); 
        }
        return mv;
    }
}
