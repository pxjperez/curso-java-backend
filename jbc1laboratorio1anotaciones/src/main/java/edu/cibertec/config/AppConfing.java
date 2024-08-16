/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.config;

import edu.cibertec.service.ConexionMysql;
import edu.cibertec.service.ConexionPostgres;
import edu.cibertec.service.HolaMundo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author jpere
 */
@Configuration
public class AppConfing {
    @Bean
    public HolaMundo holaMundoBean(){
        return new HolaMundo();
    }
    @Bean
    //@Scope("prototype")
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
}
