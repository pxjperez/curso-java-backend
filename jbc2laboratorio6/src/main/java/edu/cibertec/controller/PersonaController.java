/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
//@SessionAttributes("usuario") //De darce el caso que no se transporta la sesion entre controladores agregar la anotacion con la sesion que trabajaras
public class PersonaController {
    
    @RequestMapping("mantenimientoPersonas")
    public ModelAndView mantenimientoPersonas() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mantenimientoPersonas");
        return mv;
    }
    
}
