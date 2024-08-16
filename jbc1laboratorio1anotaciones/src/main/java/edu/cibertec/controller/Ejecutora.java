/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.config.AppConfing;
import edu.cibertec.service.Conexion;
import edu.cibertec.service.HolaMundo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jpere
 */
public class Ejecutora {
    public static void main(String[] args) {
        //ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfing.class);
        HolaMundo hm1 = (HolaMundo) cxt.getBean("holaMundoBean");
        hm1.saludar();
        HolaMundo hm2 = (HolaMundo) cxt.getBean("holaMundoBeanConPropiedades");
        hm2.saludar();        
        HolaMundo hm3 = (HolaMundo) cxt.getBean("holaMundoBeanConPropiedades");
        hm3.setNombre("Daniel");
        hm2.saludar();//Juan
        hm3.saludar();//Daniel
        Conexion cn  = (Conexion) cxt.getBean("conexionMysql");
        cn.obtenerConexion();
        cn  = (Conexion) cxt.getBean("conexionPostgres");
        cn.obtenerConexion();
    }
}
