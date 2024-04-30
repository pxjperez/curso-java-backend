/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.beans.HolaMundo;
import edu.cibertec.config.AppConfig;
import edu.cibertec.service.ImpresoraService;
import edu.cibertec.service.impl.ImpresoraServiceExcel;
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
        //ApplicationContext  contexto = new ClassPathXmlApplicationContext("beans.xml");    
        ApplicationContext contexto = new AnnotationConfigApplicationContext(AppConfig.class); 
        HolaMundo hm = (HolaMundo)contexto.getBean("holaMundo");
        hm.setNombre("JUAN");
        hm.saludar();
        HolaMundo hm1 = (HolaMundo)contexto.getBean("holaMundo");
        hm1.saludar();        
        HolaMundo hm2 = (HolaMundo)contexto.getBean("holaMundoCicloVida");
        hm2.saludar();

        ImpresoraService ipse= (ImpresoraService)contexto.getBean("impresoraServiceExcel");
        ipse.mostraTipo();
        ImpresoraService ipst= (ImpresoraService)contexto.getBean("impresoraServiceTexto");
        ipst.mostraTipo();
       ((ConfigurableApplicationContext) contexto).close();
    }
}
