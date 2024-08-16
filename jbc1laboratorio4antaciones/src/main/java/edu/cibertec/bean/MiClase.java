/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.bean;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
@Component
public abstract class MiClase {
    public void algunMetodo() {
        MiDependencia miDependencia =  instanciarMiDependencia(); 
        //MiDependencia miDependencia = new MiDependencia();
        // continuar con el método 
        miDependencia.imprimir();
    }


    @Lookup
    protected abstract MiDependencia instanciarMiDependencia();
    //return new MiDependencia();
}
