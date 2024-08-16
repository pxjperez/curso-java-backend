package edu.cibertec.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import edu.cibertec.entity.CursoEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * CursoConsumer
 */
@Slf4j
@Component
public class CursoConsumer {
    @KafkaListener(topics="${topico.nombre}")
    public void csumirCursos(CursoEntity curso){
        //logica para almacenar en la bd
        log.info("Curos con id: "+curso.getIdCurso());
    }
    
}