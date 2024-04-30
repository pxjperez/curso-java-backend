/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.beans;

import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
@Component("miDependencia")
public class MiDependencia {
    public MiDependencia() {
        System.out.println("COSTRUYE MiDependencia");
    }
    
    public void imprimir(){
        System.out.println("IMPRIMIR");
    }
}
