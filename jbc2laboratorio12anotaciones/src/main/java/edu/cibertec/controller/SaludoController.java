/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibrtec.entity.PersonaEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
public class SaludoController {
    
    @RequestMapping("saludo")
    public String saludar(){
        return "saludo";
    }
//    @RequestMapping("bienvenida")
//    public String saludar(Model modelo){
//        modelo.addAttribute("mensaje","Bienvenio al sistema desde spring");
//        return "saludo";
//    }
    
//    @RequestMapping("bienvenida")
//    public String saludar(String idioma,Model modelo){        
//        modelo.addAttribute("mensaje","Bienvenio al sistema desde spring "+ idioma);
//        return "saludo";
//    }
    
//    @RequestMapping("bienvenida")
//    public String saludar(HttpServletRequest request,Model modelo){  
//        String nombre = request.getParameter("nombre");
//        String apellido = request.getParameter("apellido");
//        modelo.addAttribute("mensaje","Bienvenio al sistema desde spring "+ nombre+" "+apellido);
//        return "saludo";
//    }
    
    @RequestMapping("bienvenida")
    public String saludar(PersonaEntity persona,Model modelo){        
        modelo.addAttribute("mensaje","Bienvenio al sistema desde spring "+ persona.getNombre()+" "+persona.getApellido());
        return "saludo";
    }
    
    @RequestMapping("saludo/{nombre}")
    public ModelAndView saludar(@PathVariable("nombre")String nombre){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/saludo");
        mv.addObject("nombre", nombre);
        return mv;
    }
    
    @RequestMapping("saludo/{nombre}/{idioma}")
    public ModelAndView saludar(@PathVariable("nombre")String nombre, @PathVariable("idioma")String idioma){
        ModelAndView mv = new ModelAndView();
        if(idioma.equals("ES")){
            mv.setViewName("/saludo");
            mv.addObject("nombre", nombre);
        }else{
            mv.setViewName("/saludoEn");
            mv.addObject("nombre", nombre);
        }        
        return mv;
    }
}
