package edu.cibertec.apimatricula.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.cibertec.apimatricula.entity.CursoEntity;
import edu.cibertec.apimatricula.entity.ErrorEntity;
import edu.cibertec.apimatricula.service.CursoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @ExceptionHandler(Exception.class)
    private ErrorEntity capturadorErrores(Exception ex){
        ErrorEntity error = new ErrorEntity(HttpStatus.CONFLICT.toString(), "Problema interno :)", "A ocurrido un error"+ex.getMessage());
        return  error;
    }

    @GetMapping //GET PARA LISTAR CONJUNTO
    @ResponseStatus
    public List<CursoEntity> ListarCurso(){
        try{
            return cursoService.listarCursos();    
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A ocurrido un error "+ex.getMessage());
        }          
    }

    @GetMapping("/{id}") //GET CON ID PARA OBTERNER UN OBJETO
    public CursoEntity obtenerCurso(@PathVariable("id") Integer id){
        return cursoService.obtenerCurso(id);
    }

    @PostMapping//POST PARA REGISTRAR UN OBJETO
    //public CursoEntity registrarCurso(CursoEntity cursoEntity){
    @ResponseStatus(HttpStatus.CREATED)
    public CursoEntity registrarCurso(@RequestBody CursoEntity cursoEntity){    
        return cursoService.registrarCurso(cursoEntity);
    }

    @PutMapping("/{id}")//PUT CON ID PARA ACTUALIZAR UN OBJETO
    public CursoEntity actualizarCurso(@PathVariable("id") Integer id, @RequestBody CursoEntity cursoEntity){
        cursoEntity.setIdCurso(id);
        return cursoService.actualizarCurso(cursoEntity);
    }

    @DeleteMapping("/{id}")//DELETE CON ID PARA ELIMINAR  (PUEDO ENVIAR UN CUERPO)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCurso(@PathVariable("id") Integer id){
        cursoService.eliminarCurso(id);
    }
}
