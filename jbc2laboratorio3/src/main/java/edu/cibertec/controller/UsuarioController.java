/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.bean.Usuario;
import edu.cibertec.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    @RequestMapping("logearv1")
    public ModelAndView logearv1(HttpServletRequest request) {        
        ModelAndView mv = new ModelAndView();
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        if (usuario != null && password != null) {
            Usuario user = new Usuario();
            user.setUser(usuario);
            user.setPassword(password);
            user=usuarioService.validarLogin(user);
            if(user!=null){
                mv.addObject("user",user);
                mv.setViewName("index");
            }else{
                mv.addObject("msgError", "No se encontro el usuario");
                mv.setViewName("login");
            }            
        }else{
            mv.addObject("msgError", "No se ingreso un Usuario y Password valido");
            mv.setViewName("login");
        }
        return mv;
    }

    //La mas utilizada para interceptar los valores que vienen del request
    @RequestMapping("logearv2")
    public ModelAndView logearv2(Usuario usuario) {
        ModelAndView mv = new ModelAndView();
        if (usuario.getUser()!= null && usuario.getPassword()!= null) {
            usuario=usuarioService.validarLogin(usuario);
            if(usuario!=null){
                mv.addObject("usuario",usuario);
                mv.setViewName("index");
            }else{
                mv.addObject("msgError", "Usuario y contraseña no validos");
                mv.setViewName("login");
            }            
        }else{
            mv.addObject("msgError", "No se ingreso un Usuario y Password valido");
            mv.setViewName("login");
        }
        return mv;
    }
}
