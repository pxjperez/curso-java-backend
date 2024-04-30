/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
@SessionAttributes(value = {"usuario"})
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping("/")
    public String mostrarLogin(){
        return "login";
    }
    
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/logear")
    public ModelAndView logear(UsuarioEntity usuario){
        ModelAndView mv=new ModelAndView();
        usuario=usuarioService.validarUsuario(usuario);
        if(usuario!=null){
            mv.setViewName("index");
            mv.addObject("usuario", usuario);
        }else{
            mv.setViewName("login");
            mv.addObject("msgError","Usuario y contraseña no validos");
        }
        return mv;
    }
    
    
}
