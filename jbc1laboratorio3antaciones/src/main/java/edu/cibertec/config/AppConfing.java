/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.config;

import edu.cibertec.bean.ConexionMysql;
import edu.cibertec.bean.ConexionPostgres;
import edu.cibertec.bean.DocumentoExcel;
import edu.cibertec.bean.DocumentoTexto;
import edu.cibertec.bean.HolaMundo;
import edu.cibertec.service.ImpresoraService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author jpere
 */
@Configuration
@Lazy(value = true)
public class AppConfing {
    @Bean
    public HolaMundo holaMundoBean(){
        return new HolaMundo();
    }
    @Bean
    @Scope("prototype")
    public HolaMundo holaMundoBeanConPropiedades(){
        HolaMundo hm = new HolaMundo();
        hm.setNombre("Juan");
        return hm;
    }
    @Bean 
    public ConexionMysql conexionMysql(){
        return new ConexionMysql();
    }
    @Bean 
    public ConexionPostgres conexionPostgres(){
        return new ConexionPostgres();
    }
    
    @Bean
    public DocumentoExcel documentoExcel(){
        return new DocumentoExcel();
    } 
    
    @Bean
    public DocumentoTexto documentoTexto(){
        return new DocumentoTexto();
    }
    
    @Bean(initMethod = "iniciar",destroyMethod = "destruir")
    @Lazy(value = true)
    public ImpresoraService impresoraServiceBean(){
        return new ImpresoraService();
    }
    
    @Bean
    @Lazy(value = true)
    public ImpresoraService impresoraServiceBeanExcel(){
        return new ImpresoraService(documentoExcel());
    }
    
    @Bean
    @Lazy(value = true)
    public ImpresoraService impresoraServiceBeanTexto(){
        return new ImpresoraService(documentoTexto());
    }
}
