/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.beans.Conexion;
import edu.cibertec.beans.HolaMundo;
import edu.cibertec.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author jpere
 */
public class Ejecutora {
    @Autowired
    @Qualifier("conexionPostges") 
    private static Conexion conexion;
    

    public static void main(String[] args) {
        //ApplicationContext contexto = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext contexto = new AnnotationConfigApplicationContext(AppConfig.class);
        HolaMundo hm = (HolaMundo) contexto.getBean("holaMundoBean"); // HolaMundo holaMundoBean = new HolaMundo();
        hm.saludar();
        HolaMundo hm1 = (HolaMundo) contexto.getBean("holaMundoBeanConPropiedad"); // HolaMundo holaMundoBean = new HolaMundo(); holaMundoBean.setNombre("JPEREZGIL");
        hm1.saludar();
        HolaMundo hm2 = (HolaMundo) contexto.getBean("holaMundoBean"); // HolaMundo holaMundoBean = new HolaMundo();
        System.out.println("==BEANS==");
        hm.saludar();
        hm.setNombre("PEDRO");
        hm2.saludar();
        Conexion cx = (Conexion) contexto.getBean("miConexion"); // HolaMundo holaMundoBean = new HolaMundo();
        cx.obtenerConexion(); 
        //conexion.obtenerConexion();
    }
}
