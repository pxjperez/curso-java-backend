/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
@RequestMapping("saludo")
public class SaludoController {
    @GetMapping
    public String saludo(){
        return "saludo";
    }
    
    @GetMapping("/nombre")
    public String saludo(Model modelo){
        modelo.addAttribute("mensaje", "Bienvenido Juan");
        return "saludonombre";
    }
    
    @GetMapping("/dato")
    public ModelAndView saludo(@RequestParam( value = "nombre",required = false) String nombre){
        ModelAndView mv = new ModelAndView();
        if(nombre==null){
            mv.setViewName("saludo");
        }else{
            mv.setViewName("saludonombre");
            mv.addObject("mensaje", "Bienvenido "+nombre);
        }        
        return mv;
    }
}
