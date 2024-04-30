/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.repository.impl;

import edu.cibertec.repository.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public class ConexionImpl implements Conexion {
  
    private Connection cn;
    
    @Override
    public Connection obtenerConexion() {
        try {
            //Conexion a la BD                
            String host = "localhost";//HOST O IP de la BD
            String port = "3306";//PUERTO que usa la BD
            String bd = "sysventa"; //BD que se usara 
            String user = "root"; //Usuario de la BD
            String password = "root"; //Contraseña de la BD
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //Varia por motor de BD
            Connection cn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + bd, user, password); //Varia por motor de BD
            return cn;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void cerrarConexion() {
        try {
            if (cn != null) {
                cn.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            cn = null;
        }
    }

}
