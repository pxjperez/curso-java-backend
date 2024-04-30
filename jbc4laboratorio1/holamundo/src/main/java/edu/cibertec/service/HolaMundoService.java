package edu.cibertec.service;

import org.springframework.stereotype.Service;

@Service
public class HolaMundoService {
    public void saludar(){
        System.out.println("Salundado desde el service!");
    }
    
}
