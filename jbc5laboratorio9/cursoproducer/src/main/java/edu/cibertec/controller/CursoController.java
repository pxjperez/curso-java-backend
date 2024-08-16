package edu.cibertec.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.CursoEntity;

@RestController
public class CursoController {
    
    @Autowired
    private KafkaTemplate   kafkaTemplate;

    @Value("${topico.nombre}")
    private String topico;

    @RequestMapping("/cursos/{id}")
    public CursoEntity publicarCurso(@PathVariable("id") Integer idCurso){
        CursoEntity curso = new CursoEntity();
        curso.setIdCurso(idCurso);
        curso.setNomembreCurso("Curso de Spring Boot");
        curso.setFechaInicio(new Date());
        curso.setAlumnosMin(10);
        curso.setAlumnosAct(0);
        curso.setEstado(1);
        kafkaTemplate.send(topico, curso);
        return curso;
    }

    @PostMapping("/cursos")
    public CursoEntity publicarCurso(@RequestBody CursoEntity curso){
        kafkaTemplate.send(topico, curso);
        return curso;
    }
}
