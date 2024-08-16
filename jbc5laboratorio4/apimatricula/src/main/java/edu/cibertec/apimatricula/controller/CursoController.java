package edu.cibertec.apimatricula.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1/cursos")
@Tag(name = "Curso",description = "Api Curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @ExceptionHandler(Exception.class)
    private ErrorEntity capturadorErrores(Exception ex){
        ErrorEntity error = new ErrorEntity(HttpStatus.CONFLICT.toString(), "Problema interno :)", "A ocurrido un error"+ex.getMessage());
        return  error;
    }

/* //forma generica
    @GetMapping //GET PARA LISTAR CONJUNTO
    public ResponseEntity<Object> ListarCurso(){
        try{
            //return ResponseEntity.status(HttpStatus.OK).body(cursoService.listarCursos()); 
            //String numero = null;numero.toCharArray();//Para generar un error 
            //return ResponseEntity.ok(cursoService.listarCursos());  
            return ResponseEntity.status(HttpStatus.OK)
                                 .header("usuario1", "jperezgil1")
                                 .header("usuario2", "jperezgil2")
                                 .header("token", "xxxxx")
                                 .body(cursoService.listarCursos());    
        }catch(Exception ex){
            ErrorEntity error = new ErrorEntity(HttpStatus.CONFLICT.toString(), "Problema interno :) desde el metodo", "A ocurrido un error"+ex.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }          
    }
*/

    //recomendada
    @GetMapping //GET PARA LISTAR CONJUNTO
    public ResponseEntity<List<CursoEntity>> ListarCurso(){
            return ResponseEntity.status(HttpStatus.OK)
                                 .header("usuario1", "jperezgil1")
                                 .header("usuario2", "jperezgil2")
                                 .header("token", "xxxxx")
                                 .body(cursoService.listarCursos().stream().filter(c->!c.getEstado().equals(-1)).collect(Collectors.toList()));            
    }

    @GetMapping("/{id}") //GET CON ID PARA OBTERNER UN OBJETO
    public ResponseEntity<CursoEntity> obtenerCurso(@PathVariable("id") Integer id){
        return ResponseEntity.ok(cursoService.obtenerCurso(id));
    }

    @PostMapping//POST PARA REGISTRAR UN OBJETO
    public ResponseEntity<CursoEntity> registrarCurso(@RequestBody CursoEntity cursoEntity) throws URISyntaxException{   
        cursoEntity=cursoService.registrarCurso(cursoEntity); 
        return ResponseEntity.created(new URI("/"+cursoEntity.getIdCurso())).body(cursoService.registrarCurso(cursoEntity));
    }

    @PutMapping("/{id}")//PUT CON ID PARA ACTUALIZAR UN OBJETO
    public ResponseEntity<CursoEntity> actualizarCurso(@PathVariable("id") Integer id, @RequestBody CursoEntity cursoEntity){
        cursoEntity.setIdCurso(id);
       return ResponseEntity.ok(cursoService.actualizarCurso(cursoEntity));
    }

    @DeleteMapping("/{id}")//DELETE CON ID PARA ELIMINAR  (PUEDO ENVIAR UN CUERPO)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminarCurso(@PathVariable("id") Integer id){
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }

}
