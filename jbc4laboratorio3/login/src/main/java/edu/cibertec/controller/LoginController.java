package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping("/")
    public String Login(){
        return "login";
    }

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @RequestMapping("accionLogin")
    public ModelAndView validarLogin(String user, String password){
        ModelAndView mav = new ModelAndView();
        if(user.equals("admin") && password.equals("123")){
            mav.setViewName("paginaPrincipal");
            mav.addObject("mensaje", mensajeBienvenida);
        }else{
            mav.setViewName("login");
            mav.addObject("msgError", "Credenciales incorrectas");
        }
        return mav;
    }
}
