/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
//@Component(value = "pepito")
@Component
@Lazy(value = true)
//@Scope(value = "prototype")
public class HolaMundo {
    private String nombre;

    public HolaMundo() {
    }

    public HolaMundo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void saludar(){
        System.out.println("Hola desde un bean a "+this.nombre);
    }
    
    @PostConstruct
    public void antesCreacion(){
        System.out.println("CREANDO");
    }
    
    @PreDestroy
    public void despuesDestruccion(){
        System.out.println("DESTRUYENDO");
    }
}
