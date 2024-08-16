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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author jpere
 */
@Configuration
@ComponentScan(basePackages = {"edu.cibertec"})
public class AppConfing {
    @Bean
    @Scope("prototype")
    public HolaMundo holaMundoBeanConPropiedades(){
        HolaMundo hm = new HolaMundo();
        hm.setNombre("Juan");
        return hm;
    }
}
