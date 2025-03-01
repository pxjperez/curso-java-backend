package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.stereotype.Component;

import edu.cibertec.entity.CursoEntity;
import lombok.extern.java.Log;


@Component
@Log
public class CursoController {



    @KafkaListener(topics = "${topico.nombre}")
    public void leerCurso(CursoEntity curso) {
       //Aqui pueden agregar cualquier logica para el topico 
       log.info("Curso recibido: " + curso);
    }


    

}
