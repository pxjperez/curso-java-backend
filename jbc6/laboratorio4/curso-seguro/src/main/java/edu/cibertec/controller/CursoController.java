package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.service.CursoService;

@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoEntity> listarCursos() {       
        return cursoService.listarCursos();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("{idCurso}")
    public CursoEntity obtenerCursoPorId(@PathVariable Integer idCurso) {
        return cursoService.obtenerCurso(idCurso);
    }
    



}
