/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.beans.HolaMundo;
import edu.cibertec.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jpere
 */
public class Ejecutora {
    public static void main(String[] args) {
         //ApplicationContext  contexto = new ClassPathXmlApplicationContext("beans.xml");    
        ApplicationContext contexto = new AnnotationConfigApplicationContext(AppConfig.class); 
        HolaMundo hm = (HolaMundo)contexto.getBean("holaMundo");
        hm.setNombre("JUAN");
        hm.saludar();
    }
}
