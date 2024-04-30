package edu.cibertec.curso.controller;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.cibertec.curso.entity.CursoEntity;
import edu.cibertec.curso.entity.ErrorEntity;
import edu.cibertec.curso.service.CursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    
    @ExceptionHandler(Exception.class)
    private ResponseEntity capturarErrores(){
        ErrorEntity error = new ErrorEntity(HttpStatus.CONFLICT.toString(), "Problema interno","A ocurrido un error en el microservicio curso");
        //return new ResponseEntity(error,HttpStatus.CONFLICT);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CursoEntity> listarCursos() {
        try{
            return cursoService.listarCursos();
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"No se puede listar los cursos",ex);
        }        
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<CursoEntity> obtenerCurso(@PathVariable("idCurso") Integer idCurso) {
        try{
            //return new ResponseEntity(cursoSevice.obtenerCurso(idCurso),HttpStatus.OK); //Forma 1
            //return ResponseEntity.ok().body(cursoSevice.obtenerCurso(idCurso)); //Forma 1
            return ResponseEntity.ok(cursoService.obtenerCurso(idCurso)); //Forma 3 (La form mas recomendada)
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso no encontrado",ex);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<Object> insertarCurso(@RequestBody CursoEntity curso) {
        try{
            //return new ResponseEntity(cursoSevice.insertarCurso(curso),HttpStatus.CREATED);
            curso=cursoService.insertarCurso(curso); 
            return ResponseEntity.created(new URI("/"+curso.getIdCurso())) //Envia el codigo del estado de la respuesta
                                 .header("usuario","jperezgil") //Envia las cabeceras de la respuesta
                                 .body(curso);//Envia el cuerpo de la respuesta
        }catch(Exception ex){
            ErrorEntity error = new ErrorEntity(HttpStatus.FORBIDDEN.toString(), "Problema interno","Curso no se pudo grabar");
            //return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().body(error);
        }        
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity actualizarCurso(@PathVariable("idCurso") Integer idCurso, @RequestBody CursoEntity curso) {
        try{
            curso.setIdCurso(idCurso);
            return new ResponseEntity(cursoService.insertarCurso(curso),HttpStatus.OK);
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Curso no se pudo actualizar",ex);
        }
    }

    @DeleteMapping("/{idCurso}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCurso(@PathVariable("idCurso") Integer idCurso) {
        cursoService.eliminarCurso(idCurso);
    }
}
