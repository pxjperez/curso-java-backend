/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service;

/**
 *
 * @author jpere
 */
public class ConexionPostgres implements Conexion{
    @Override
    public void obtenerConexion() {
        System.out.println("Abriendo conexion Posgres");
    }

    @Override
    public void cerrarConexion() {
        System.out.println("Cerrando conexion Posgres");
    }
}
