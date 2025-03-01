package edu.cibertec.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.CursoEntity;

@RestController
public class CursoController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${topico.nombre}")
    private String topicoNombre;

    @RequestMapping("/curso/{idCurso}")
    public CursoEntity curso(@PathVariable Integer idCurso) {
        CursoEntity curso = new CursoEntity(idCurso, "Curso de Spring Boot", new Date(), 10, 0, 1);
        kafkaTemplate.send(topicoNombre, curso);
        return curso;
    }
    
}
