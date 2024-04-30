/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.repository.MiClase;
import edu.cibertec.config.AppConfig;
import edu.cibertec.service.ImpresoraService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 *
 * @author jpere
 */
@Controller
public class Ejecutora {

    public static void main(String[] args) {
        //ApplicationContext  contexto = new ClassPathXmlApplicationContext("beans.xml");    
        ApplicationContext contexto = new AnnotationConfigApplicationContext(AppConfig.class);
        
        ImpresoraService isE = (ImpresoraService) contexto.getBean("impresoraServiceExcel");
        isE.imprimir();
        ImpresoraService isT = (ImpresoraService) contexto.getBean("impresoraServiceTexto");
        isT.imprimir();
        
        MiClase miClase = (MiClase) contexto.getBean("miClase");
        miClase.setNombre("JUAN CARLOS");
        miClase.algunMetodo();
    }

}
