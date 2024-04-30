/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.beans.HolaMundo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jpere
 */
public class Ejecutora {
    public static void main(String[] args) {
        ApplicationContext  contexto = new ClassPathXmlApplicationContext("beans.xml");    
        //ApplicationContext contexto = new AnnotationConfigApplicationContext(AppConfig.class);      
        HolaMundo hm1 = (HolaMundo) contexto.getBean("holaMundo");
        hm1.setNombre("Daniel");
        HolaMundo hm2 = (HolaMundo) contexto.getBean("holaMundo");
        hm2.setNombre("Javier");
        hm1.saludar();
        hm2.saludar();
        
        HolaMundo hm3 = (HolaMundo) contexto.getBean("holaMundoCicloVida");
        hm3.saludar();
        
        ((ConfigurableApplicationContext)contexto).close();
       
    }
}
