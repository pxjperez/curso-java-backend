package edu.cibertec.apimatricula.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.apimatricula.entity.CursoEntity;
import edu.cibertec.apimatricula.service.CursoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @GetMapping
    public List<CursoEntity> ListarCurso(){
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public CursoEntity obtenerCurso(@PathVariable("id") Integer id){
        return cursoService.obtenerCurso(id);
    }

    @PostMapping
    //public CursoEntity registrarCurso(CursoEntity cursoEntity){
    public CursoEntity registrarCurso(@RequestBody CursoEntity cursoEntity){    
        return cursoService.registrarCurso(cursoEntity);
    }

    @PutMapping("/{id}")
    public CursoEntity actualizarCurso(@PathVariable("id") Integer id, @RequestBody CursoEntity cursoEntity){
        cursoEntity.setIdCurso(id);
        return cursoService.actualizarCurso(cursoEntity);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable("id") Integer id){
        cursoService.eliminarCurso(id);
    }
}
