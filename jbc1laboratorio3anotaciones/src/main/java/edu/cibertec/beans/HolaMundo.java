/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
@Component
public class HolaMundo {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void saludar(){
        System.out.println("HOLA "+this.nombre);
    }
    
    //Si se desea utilizar en todas las clases anotaciones puedo utilizar 
    @PostConstruct
    public void iniciar(){
        System.out.println("iniciando");
    }
    
    //Si se desea utilizar en todas las clases anotaciones puedo utilizar 
    @PreDestroy
    public void destruir(){
        System.out.println("destruyendo");
    }
}
