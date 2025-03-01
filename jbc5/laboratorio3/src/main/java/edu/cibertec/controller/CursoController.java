package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.entity.ErrorEntity;
import edu.cibertec.service.CursoService;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;


    //Cuando quiero controllar las respuestas de las execepciones de manera generica
    @ExceptionHandler(Exception.class)
    @ResponseStatus
    private  ErrorEntity capturadorErrores(Exception ex) {
        ErrorEntity error = new ErrorEntity();
        String[] datosError = ex.getMessage().replaceAll("\"", ";").split(";");
        error.setEstatus(datosError[0].trim());
        error.setMensaje(datosError[1].trim());
        error.setError(ex.getClass().getSimpleName());
        return error;
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<CursoEntity> listarCursosXml() {
        return cursoService.listarCursos();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CursoEntity> listarCursos() {
        try {
            String mensaje=null;
            mensaje.getBytes();
            return cursoService.listarCursos();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron cursos");
        }
    }

    @GetMapping(value = "/{idCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CursoEntity obtenerCurso(@PathVariable("idCurso") Integer idCurso) {
        return cursoService.obtenerCurso(idCurso);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    //public CursoEntity registrarCurso(CursoEntity curso) { //Cuando nosotros no le especificamos que va a llegar como un body nos a enviarlo desde un formulario
    public CursoEntity registrarCurso(@RequestBody CursoEntity curso) {
        return cursoService.registrarCurso(curso);
    }

    @PutMapping(value = "/{idCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CursoEntity actualizarCurso(@PathVariable("idCurso") Integer idCurso, @RequestBody CursoEntity curso) {
        curso.setIdCurso(idCurso);
        return cursoService.actualizarCurso(curso);
    }

    @DeleteMapping(value = "/{idCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCurso(@PathVariable("idCurso") Integer idCurso) {
        cursoService.eliminarCurso(idCurso);
    }
    
}
