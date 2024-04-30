package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @RequestMapping("/")
    public String mostrarLogin() {
        return "login";
    }  
 
    @RequestMapping("login")
    public ModelAndView validarLogin(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        if(usuario!=null&&!usuario.equals("")&&password!=null&&!password.equals("")){
            if(usuario.equalsIgnoreCase("admin") && password.equalsIgnoreCase("12345")){
                mv.addObject("mensaje", mensajeBienvenida+" "+usuario);
                mv.setViewName("principal");
            }else{
                mv.addObject("msgError", "Credenciales incorrectas.");
                mv.setViewName("login");
            }
        }else{
            mv.addObject("msgError", "Estimado usuario debe de ingresar un usuario y password valido.");
            mv.setViewName("login");
        }
        return  mv; 
    }    
}
