/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.bean;

import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
@Component
public class MiDependencia {
     public MiDependencia() {
        System.out.println("Construyendo MiDependencia");
    }
    
    public void imprimir(){
        System.out.println("Imprimir desde MiDependencia");
    }
}
