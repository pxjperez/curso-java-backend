/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.repository;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
//@Component ("miClase")
@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) //Esta configuracion se recomienda modificar por clase y por defecto es singleton
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
//@Scope("singleton")
//@Lazy(true)
public abstract class MiClase {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void algunMetodo() {
        MiDependencia miDependencia = instanciarMiDependencia();
        // continuar con el método 
        miDependencia.imprimir(nombre);
    }

    @Lookup
    protected abstract MiDependencia instanciarMiDependencia();

}
