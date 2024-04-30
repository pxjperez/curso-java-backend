/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

/**
 *
 * @author jpere
 */
public class ConexionMysql  implements Conexion {

    @Override
    public void obtenerConexion() {
      System.out.println("CONECTANDO A MYSQL");    
    }

    @Override
    public void cerrarConexion() {
       System.out.println("DESCONECTANDO A MYSQL");    
    }
    
}
