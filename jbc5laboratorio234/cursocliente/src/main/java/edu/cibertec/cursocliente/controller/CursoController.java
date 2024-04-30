package edu.cibertec.cursocliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.cursocliente.service.CursoService;

@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @RequestMapping("/")
    public String  index(){
        return "redirect:/mantenimientoCursos";
    }
    @RequestMapping("mantenimientoCursos")
    public ModelAndView cursoListar() {
        ModelAndView mv = new ModelAndView("mantenimientoCursos","listaCursos",cursoService.listarCursos());
        return mv;
    }
}
