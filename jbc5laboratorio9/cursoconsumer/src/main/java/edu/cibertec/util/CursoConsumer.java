package edu.cibertec.util;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import edu.cibertec.entity.CursoEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CursoConsumer {
    @KafkaListener(topics="${topico.nombre}")
    public void consumirCursos(CursoEntity curso) throws Exception{
        log.info("Mensaje recibido: {}", curso);
    }
}
