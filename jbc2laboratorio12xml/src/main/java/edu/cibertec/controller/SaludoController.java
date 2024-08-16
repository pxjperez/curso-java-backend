/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @RequestMapping("saludo/{nombre}")
    public ModelAndView saludar(@PathVariable("nombre")String nombre){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/saludo");
        mv.addObject("nombre", nombre);
        return mv;
    }
}
