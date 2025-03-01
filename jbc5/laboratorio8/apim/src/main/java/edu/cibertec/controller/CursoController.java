package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.service.CursoService;

@RestController
@RequestMapping("apim/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoEntity> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("{idCurso}")
    public CursoEntity obtenerCurso(@PathVariable Integer idCurso) {
        return cursoService.obtenerCurso(idCurso);
    }
    
    @PostMapping
    public CursoEntity crearCurso(@RequestBody CursoEntity curso) {
        return cursoService.registrarCurso(curso);
    }

    @PutMapping("{idCurso}")
    public CursoEntity actualizarCurso(@PathVariable Integer idCurso, @RequestBody CursoEntity curso) {
        curso.setIdCurso(idCurso);
        return cursoService.actualizarCurso(curso);
    }

    @DeleteMapping("{idCurso}")
    public CursoEntity eliminarCurso(@PathVariable Integer idCurso) {
        return cursoService.eliminarCurso(idCurso);
    }
}
