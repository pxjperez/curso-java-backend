package edu.cibertec.cursoseguro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.cursoseguro.service.CursoService;

@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @RequestMapping("/")
    public ModelAndView listarCursos(){
        return new ModelAndView("curso","listaCursos",cursoService.listarCursos());
    }
}
