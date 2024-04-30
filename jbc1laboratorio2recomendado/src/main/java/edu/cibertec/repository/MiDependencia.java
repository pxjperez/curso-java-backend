/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public class MiDependencia {
    public MiDependencia() {
        System.out.println("COSTRUYE MiDependencia");
    }
    
    public void imprimir(String nombre){
        System.out.println("IMPRIMIR LOS TRABAJOS DE "+nombre);
    }
}
