/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.repository;

import java.sql.Connection;

/**
 *
 * @author jpere
 */
public interface Conexion {
    public Connection obtenerConexion();
    public void cerrarConexion();
}
