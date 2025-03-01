package edu.cibertec.controller;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.service.CursoService;

@Controller
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/mantenimientoCursos")
    public ModelAndView mantenimientoCursos() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("listaCursos", cursoService.listarCursos());
        mav.setViewName("mantenimientoCursos");
        return mav;
    }



}
