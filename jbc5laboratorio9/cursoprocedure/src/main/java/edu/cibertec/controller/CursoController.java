package edu.cibertec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.service.CursoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("api/cursos")
@Tag(name = "Curso", description = "Api Curso")
@RestController
@Slf4j
public class CursoController {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Value("${topico.nombre}")
    private String topico;
    @Autowired
    private CursoService cursoService;
    @Value("${server.port}")
    private String port;
    
    @GetMapping("/{idCurso}")
    public ResponseEntity<CursoEntity> obtenerCurso(@PathVariable(value="idCurso") Integer idCurso){
        try{
            log.info(port);
            CursoEntity curso = this.cursoService.obtenerCurso(idCurso);
            kafkaTemplate.send(topico, curso);
            return ResponseEntity.ok().body(curso);
        }catch(Exception ex){
           kafkaTemplate.send(topico, null);
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
}
