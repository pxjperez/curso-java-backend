/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.config;

import edu.cibertec.beans.HolaMundo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author jpere
 */
@Configuration
@ComponentScan(basePackages = {"edu.cibertec"}, lazyInit = true )
public class AppConfig {
    @Bean(initMethod = "antesCreacion",destroyMethod = "despuesDestruccion")
    @Lazy
    public HolaMundo holaMundoCicloVida(){
        return new HolaMundo();
    }
}
