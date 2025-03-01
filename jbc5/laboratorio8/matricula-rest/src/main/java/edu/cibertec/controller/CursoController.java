package edu.cibertec.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v1/cursos")
@Tag(name = "Cursos", description = "API de Cursos")
@Log
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Value("${server.port}")
    private String puerto;

    @GetMapping
    @Operation(summary = "Listar Cursos", description = "Lista de Cursos")
    public ResponseEntity<List<CursoEntity>> listarCursos() {
        try {            
            //Linkto foreach cursoService.listarCursos()
            List<CursoEntity> listaCursos = cursoService.listarCursos();
            listaCursos.forEach(curso -> {
                curso.add(linkTo(methodOn(CursoController.class).obtenerCurso(curso.getIdCurso())).withRel("Ver detalle de "+curso.getNombreCurso()));
            });
            log.info("Se cargo la instancia del puerto:"+puerto);
            return ResponseEntity.ok(listaCursos);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{idCurso}")
    @Operation(summary = "Obtener cursos", description = "Obtener cursos")
    public ResponseEntity<CursoEntity> obtenerCurso(@PathVariable("idCurso") Integer idCurso) {
        try {
            //Los hiperviculos son recomendados utilizar en los listados y no en los propios objetos para mostrar links a si mismos
            //return new ResponseEntity<>(cursoService.obtenerCurso(idCurso).add(linkTo(methodOn(CursoController.class).obtenerCurso(idCurso)).withSelfRel()), HttpStatus.OK);
            return new ResponseEntity<>(cursoService.obtenerCurso(idCurso), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }       
    }

   @PostMapping
   @Operation(summary = "Registrar cursos", description = "Registrar cursos")
   public ResponseEntity<CursoEntity> registrarCurso(@RequestBody CursoEntity curso) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .header("AUTOR", "JPEREZGIL")
                                 .header("FECHA", (new Date()).toString())
                                 .body(cursoService.registrarCurso(curso));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .header("AUTOR", "JPEREZGIL")
                                 .header("FECHA", (new Date()).toString()) 
                                 .build();
        }        
    }

    @PutMapping(value = "/{idCurso}")
    @Operation(summary = "Actualizar cursos", description = "Actualizar cursos")
    public ResponseEntity<CursoEntity> actualizarCurso(@PathVariable("idCurso") Integer idCurso, @RequestBody CursoEntity curso) {
       try {
        curso.setIdCurso(idCurso);
        return ResponseEntity.ok(cursoService.actualizarCurso(curso));
       } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
        
    }

    @DeleteMapping(value = "/{idCurso}")
    @Operation(summary = "Eliminar cursos", description = "Eliminar cursos")
    public ResponseEntity<CursoEntity>  eliminarCurso(@PathVariable("idCurso") Integer idCurso) {
        try {
            cursoService.eliminarCurso(idCurso);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                                 .header("AUTOR", "JPEREZGIL")
                                 .header("FECHA", (new Date()).toString()) 
                                 .build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .header("AUTOR", "JPEREZGIL")
                                 .header("FECHA", (new Date()).toString()) 
                                 .build();
        } 
    }
    
}
