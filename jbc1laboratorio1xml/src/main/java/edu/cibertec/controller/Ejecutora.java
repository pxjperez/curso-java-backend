/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.beans.HolaMundo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jpere
 */
public class Ejecutora {
    public static void main(String[] args) {
        ApplicationContext contexto = new ClassPathXmlApplicationContext("beans.xml");
        HolaMundo hm1 = (HolaMundo) contexto.getBean("holaMundoBean"); // HolaMundo holaMundoBean = new HolaMundo();
        hm1.saludar();
        
        HolaMundo hm2 = (HolaMundo) contexto.getBean("holaMundoBean"); // HolaMundo holaMundoBean = new HolaMundo();
        hm1.setNombre("pedro");
        hm2.saludar();
        hm1.saludar();
        
        HolaMundo hm3 = (HolaMundo) contexto.getBean("holaMundoBeanConPropiedad"); // HolaMundo holaMundoBean = new HolaMundo();
        hm3.saludar();
    }
}
