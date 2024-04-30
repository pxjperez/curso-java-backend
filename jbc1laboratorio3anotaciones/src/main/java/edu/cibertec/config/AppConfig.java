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
import org.springframework.context.annotation.Scope;

/**
 *
 * @author jpere
 */
@Configuration
@ComponentScan(basePackages = {"edu.cibertec"}, lazyInit = true )
public class AppConfig {
//    @Bean(initMethod = "iniciar",destroyMethod = "destruir")
//    @Scope("prototype")
//    public HolaMundo holaMundo(){
//        return new HolaMundo();
//    }
//    
    @Bean(initMethod = "iniciar",destroyMethod = "destruir")
    @Lazy
    public HolaMundo holaMundoCicloVida(){
        return new HolaMundo();
    }
}
