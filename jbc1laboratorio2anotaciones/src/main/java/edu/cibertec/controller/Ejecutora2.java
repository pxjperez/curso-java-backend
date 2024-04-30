/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.beans.Documento;
import edu.cibertec.config.AppConfig;
import edu.cibertec.service.ImpresoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author jpere
 */
public class Ejecutora2 {
    public static void main(String[] args) {
        ApplicationContext contexto = new AnnotationConfigApplicationContext(AppConfig.class);
        Documento documentoExcel = (Documento) contexto.getBean("documentoExcel");
        documentoExcel.imprimir(); 
        Documento documentoTexto = (Documento) contexto.getBean("documentoTexto");
        documentoTexto.imprimir(); 
        
    }
}
