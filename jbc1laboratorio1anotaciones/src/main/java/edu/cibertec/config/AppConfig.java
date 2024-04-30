/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.config;

import edu.cibertec.beans.Conexion;
import edu.cibertec.beans.ConexionMysql;
import edu.cibertec.beans.ConexionPostges;
import edu.cibertec.beans.HolaMundo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author jpere
 */
@Configuration
public class AppConfig {
    @Bean
    //@Scope("prototype")
    public HolaMundo holaMundoBean(){
        return new HolaMundo();
    }
    @Bean()
    public HolaMundo holaMundoBeanConPropiedad(){
        HolaMundo holamundo = new HolaMundo();
        holamundo.setNombre("JPEREZGIL");
        //hacer logica y luego devolver una instancia
        return holamundo;
    }
    @Value("MYSQL")
    private String tipoConexion;
    @Bean
    public Conexion miConexion (){
        if(this.tipoConexion.equals("MYSQL")){
            return new ConexionMysql();
        }else{
            return new ConexionPostges();
        }
    }
}
