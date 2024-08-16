/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.bean;

import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public class ConexionMysql implements Conexion{

    @Override
    public void obtenerConexion() {
        System.out.println("Abriendo conexion Mysql");
    }

    @Override
    public void cerrarConexion() {
        System.out.println("Cerrando conexion Mysql");
    }
        
}
