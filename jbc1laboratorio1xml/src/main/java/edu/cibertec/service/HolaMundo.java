/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service;

/**
 *
 * @author jpere
 */
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
        if(this.nombre!=null){
            System.out.println("Saludando desde spring a "+this.nombre);
        }else{
            System.out.println("Saludando desde spring");
        }        
    }
    
}
