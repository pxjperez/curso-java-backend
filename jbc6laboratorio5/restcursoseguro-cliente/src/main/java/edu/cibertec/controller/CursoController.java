package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import edu.cibertec.entity.CursoEntity;

import edu.cibertec.service.CursoService;


@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoEntity>listarCursos(){
        return cursoService.listarCursos();
    }
    
    @GetMapping("{idCurso}")
    public CursoEntity obtenerCurso(@PathVariable("idCurso") Integer idCurso) {
        return cursoService.obtenerCurso(idCurso);
    }
    
}
