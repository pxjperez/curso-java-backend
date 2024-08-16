package edu.cibertec.matricula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.matricula.service.CursoService;

@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @RequestMapping("listarCursos")
    public ModelAndView listarCursos() {
        ModelAndView mv = new ModelAndView("cursos");
        mv.addObject("listaCurso", cursoService.listarCursos());
        return mv;
    }

    @RequestMapping("cursoEliminar")
    public ModelAndView cursoEliminar(Integer idCurso) {
        ModelAndView mv = new ModelAndView("redirect:/listarCursos");
        cursoService.eliminarCurso(idCurso);
        return mv;
    }


    
}
