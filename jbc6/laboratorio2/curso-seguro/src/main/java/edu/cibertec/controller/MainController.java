package edu.cibertec.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @RequestMapping("/")
    public String index() {
        return "principal";
    }

    @RequestMapping("login")
    public ModelAndView login(String error, Principal principal) {
        if(error!=null){
            return new ModelAndView("login", "error", "Usuario y/o contraseña incorrectos");
        }else{
            if(principal!=null){
                return new ModelAndView("redirect:/");
            }else{
                return new ModelAndView("login");
            }
        }
    }
}
