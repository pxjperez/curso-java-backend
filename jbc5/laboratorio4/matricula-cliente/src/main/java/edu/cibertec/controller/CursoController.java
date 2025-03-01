package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.service.CursoService;

@Controller
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @RequestMapping("/mantenimientoCursos")
    public ModelAndView listarCursos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mantenimientoCursos");
        mv.addObject("listaCursos", cursoService.listarCursos());    
        return mv;
    }

    @RequestMapping("/eliminarCurso")
    public ModelAndView eliminarCurso(Integer idCurso) {
        cursoService.eliminarCurso(idCurso);
        return new ModelAndView("redirect:/mantenimientoCursos");
    }
}
