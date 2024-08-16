/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

//import edu.cibertec.config.AppConfing;
import edu.cibertec.bean.Conexion;
import edu.cibertec.bean.HolaMundo;
import edu.cibertec.bean.MiClase;
import edu.cibertec.service.ImpresoraService;
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
        ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
        //ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfing.class);
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
        
        System.out.println("PROBANDO INYECION CON ANOTACIONES");
        ImpresoraService is  = (ImpresoraService) cxt.getBean("impresoraService");
        is.imprimirDocumento();
        is.imprimirDocumentoTexto();
        
        
        System.out.println("INYECCION POR METODO");
        MiClase mc= (MiClase) cxt.getBean("miClase");
        mc.algunMetodo();
        
        ((ConfigurableApplicationContext)cxt).close();
    }
}
