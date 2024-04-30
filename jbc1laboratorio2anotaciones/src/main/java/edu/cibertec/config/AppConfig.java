/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.config;

import edu.cibertec.beans.Documento;
import edu.cibertec.beans.DocumentoExcel;
import edu.cibertec.beans.DocumentoTexto;
import edu.cibertec.service.ImpresoraService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jpere
 */
@Configuration 
@ComponentScan(basePackages = {"edu.cibertec"}, lazyInit = true )
public class AppConfig {
//    @Bean
//    public Documento documentoExcel(){
//        return new DocumentoExcel();
//    }
//    
//    @Bean
//    public Documento documentoTexto(){
//        return new DocumentoTexto();
//    }
//    
//    @Bean
//    public ImpresoraService impresoraService(){
//        return new ImpresoraService();
//    }
//    
//    @Bean
//    public ImpresoraService impresoraServiceExcel(){
//        return new ImpresoraService(new DocumentoExcel());
//    }
//    
//    @Bean
//    public ImpresoraService impresoraServiceTexto(){
//        return new ImpresoraService(new DocumentoTexto());
//    }
//    
//    @Bean
//    public ImpresoraService impresoraServiceTextoMetodo(){
//        ImpresoraService impresosaraService = new ImpresoraService();
//        impresosaraService.setDocumento(new DocumentoTexto());
//        return impresosaraService;
//    }

}
