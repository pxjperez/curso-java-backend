package edu.cibertec.service;

import org.springframework.stereotype.Service;

@Service
public class HolaMundoService {
    public void saludar(){
        System.out.println("Hola Mundo desde Spring Boot");
    }
}
