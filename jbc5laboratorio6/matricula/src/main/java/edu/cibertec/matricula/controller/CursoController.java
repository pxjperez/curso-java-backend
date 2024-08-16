package edu.cibertec.matricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.matricula.entity.CursoEntity;
import edu.cibertec.matricula.service.CursoService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v1/cursos")
@Tag(name = "Curso", description = "Api Curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoEntity>> listarCursos() {
        List<CursoEntity> listarCursos = cursoService.listarCursos();
        try {           
            listarCursos.forEach(c->c.add(linkTo(methodOn(CursoController.class).obtenerCurso(c.getIdCurso())).withRel("curso")));
        } catch (Exception e) {
            listarCursos=null;
        }
        return ResponseEntity.status(HttpStatus.OK)
                             .header("Usuer", "jperezgil")
                             .body(listarCursos);
    }

    @GetMapping("{idCurso}")
    public ResponseEntity<CursoEntity> obtenerCurso(@PathVariable("idCurso") Integer idCurso) {

        CursoEntity curso = cursoService.obtenerCurso(idCurso);
        curso.add(linkTo(methodOn(CursoController.class).obtenerCurso(idCurso)).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK)
                             .header("Usuer", "jperezgil")
                             .body(curso);
    }
    
}
