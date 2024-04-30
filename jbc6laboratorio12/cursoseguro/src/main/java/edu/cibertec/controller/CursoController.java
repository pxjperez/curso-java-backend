package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import edu.cibertec.service.CursoService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @RequestMapping("/listarCursos")
    public String listarCursos(Model model) {
        model.addAttribute("listaCursos", cursoService.listarCursos());
        return "listarCursos";
    }
    

}
