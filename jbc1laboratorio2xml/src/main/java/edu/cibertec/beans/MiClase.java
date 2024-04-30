/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

/**
 *
 * @author jpere
 */
public abstract class MiClase {
    public void algunMetodo() {
        MiDependencia miDependencia =  instanciarMiDependencia();       
        // continuar con el método 
        miDependencia.imprimir();
    }

    protected abstract MiDependencia instanciarMiDependencia();

}
