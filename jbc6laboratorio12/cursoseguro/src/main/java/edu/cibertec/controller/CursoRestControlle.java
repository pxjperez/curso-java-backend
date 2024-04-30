package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.service.CursoService;

@RestController
@RequestMapping("api/v1/cursos")
public class CursoRestControlle {
    @Autowired
    private CursoService cursoservice;

    @GetMapping
    public List<CursoEntity> listarCursos(){
        return cursoservice.listarCursos();
    }

    
}
