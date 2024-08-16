/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.repository.impl;

import edu.cibertec.repository.ConexionRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.stereotype.Repository;
/**
 *
 * @author jpere
 */
@Repository
public class ConexionRepositoryImpl implements ConexionRepository{

    private Connection cn;
    @Override
    public Connection obtenerConexion() {
        
      try{
          //Propiedades de conexion a la BD 
          String host = "localhost"; //Host o Ip de la BD
          String port = "3306"; //Puerto que usa la BD
          String bd = "sysventa";//Nombre de la BD que se usara
          String user ="root";//Usuario de la BD
          String password="root";//Password de la BD
          //Cadena de conexion (Varia segun el motor de BD)
          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
          cn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+bd,user,password);
          return cn;
      }catch(Exception ex){
          System.out.println(ex.getMessage());
          cn=null;
          return cn;
      }
    
    }

    @Override
    public void cerrarConexion() {
        try{
            if(cn!=null){
                cn.close();
                cn=null;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            cn=null;
        }
    }
    
}
