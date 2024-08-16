/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.repository.impl;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.ConexionRepository;
import edu.cibertec.repository.UsuarioRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author jpere
 */
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{


    @Autowired
    private ConexionRepository conexionRepository;

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
       UsuarioEntity resultado=null;
       try{
           //1.- Conectarce a la BD
           Connection  cn = conexionRepository.obtenerConexion();
           //2.- Definir la consulta SQL
           String sql = "SELECT * FROM usuario WHERE user=? AND password=?";
           //3.- Ejecutar la consulta SQL
           PreparedStatement ps = cn.prepareStatement(sql);
           ps.setString(1, usuario.getUser());
           ps.setString(2, usuario.getPassword());
           ResultSet rs = ps.executeQuery();
           //4.- Almacenar el resultado en un objeto Java
           while(rs.next()){
               resultado = new UsuarioEntity();
               resultado.setIdUsuario(rs.getInt("idusuario"));
               resultado.setUser(rs.getString("user"));
               resultado.setPassword(rs.getString("password"));
               resultado.setNombreCompleto(rs.getString("nombreCompleto"));
               resultado.setFoto(rs.getBytes("foto"));
           }
           //5.- Cerrar conexion
           conexionRepository.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
           conexionRepository.cerrarConexion();
           resultado=null;
       }
       return resultado;
    }

    @Override
    public List<UsuarioEntity> listarUsuario() {
       List<UsuarioEntity> resultado=null;
       try{
           //1.- Conectarce a la BD
           Connection  cn = conexionRepository.obtenerConexion();
           //2.- Definir la consulta SQL
           String sql = "SELECT * FROM usuario";
           //3.- Ejecutar la consulta SQL
           PreparedStatement ps = cn.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           //4.- Almacenar el resultado en un objeto Java
           resultado=new ArrayList<>();
           while(rs.next()){
               UsuarioEntity usuario = new UsuarioEntity();
               usuario.setIdUsuario(rs.getInt("idusuario"));
               usuario.setUser(rs.getString("user"));
               usuario.setPassword(rs.getString("password"));
               usuario.setNombreCompleto(rs.getString("nombreCompleto"));
               usuario.setFoto(rs.getBytes("foto"));
               resultado.add(usuario);
           }
           //5.- Cerrar conexion
           conexionRepository.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
           conexionRepository.cerrarConexion();
           resultado=null;
       }
       return resultado;
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
       UsuarioEntity resultado=null;
       try{
           //1.- Conectarce a la BD
           Connection  cn = conexionRepository.obtenerConexion();
           //2.- Definir la consulta SQL
           String sql = "SELECT * FROM usuario WHERE idusuario=?";
           //3.- Ejecutar la consulta SQL
           PreparedStatement ps = cn.prepareStatement(sql);
           ps.setInt(1, idUsuario);
           ResultSet rs = ps.executeQuery();
           //4.- Almacenar el resultado en un objeto Java
           while(rs.next()){
               resultado = new UsuarioEntity();
               resultado.setIdUsuario(rs.getInt("idusuario"));
               resultado.setUser(rs.getString("user"));
               resultado.setPassword(rs.getString("password"));
               resultado.setNombreCompleto(rs.getString("nombreCompleto"));
               resultado.setFoto(rs.getBytes("foto"));
           }
           //5.- Cerrar conexion
           conexionRepository.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
           conexionRepository.cerrarConexion();
           resultado=null;
       }
       return resultado;
    }

    @Override
    public Integer insertarUsuario(UsuarioEntity usuario) {
       Integer resultado=0;
       try{
           //1.- Conectarce a la BD
           Connection  cn = conexionRepository.obtenerConexion();
           //2.- Definir la consulta SQL
           String sql = "INSERT INTO usuario(user,password,nombreCompleto)"
                        +" VALUES (?,?,?)";
           //3.- Ejecutar la consulta SQL
           PreparedStatement ps = cn.prepareStatement(sql);
           ps.setString(1, usuario.getUser());
           ps.setString(2, usuario.getPassword());
           ps.setString(3, usuario.getNombreCompleto());
           resultado = ps.executeUpdate();
           //5.- Cerrar conexion
           conexionRepository.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
           conexionRepository.cerrarConexion();
           resultado=0;
       }
       return resultado;
    }

    @Override
    public Integer actualizarUsuario(UsuarioEntity usuario) {
       Integer resultado=0;
       try{
           //1.- Conectarce a la BD
           Connection  cn = conexionRepository.obtenerConexion();
           //2.- Definir la consulta SQL
           String sql = "UPDATE usuario SET user=?, password=?, nombreCompleto=?"
                        +" WHERE idusuario=?";
           //3.- Ejecutar la consulta SQL
           PreparedStatement ps = cn.prepareStatement(sql);
           ps.setString(1, usuario.getUser());
           ps.setString(2, usuario.getPassword());
           ps.setString(3, usuario.getNombreCompleto());
           ps.setInt(4, usuario.getIdUsuario());
           resultado = ps.executeUpdate();
           //5.- Cerrar conexion
           conexionRepository.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
           conexionRepository.cerrarConexion();
           resultado=0;
       }
       return resultado;
    }

    @Override
    public Integer eliminarUsuario(Integer idUsuario) {
       Integer resultado=0;
       try{
           //1.- Conectarce a la BD
           Connection  cn = conexionRepository.obtenerConexion();
           //2.- Definir la consulta SQL
           String sql = "DELETE FROM usuario"
                        +" WHERE idusuario=?";
           //3.- Ejecutar la consulta SQL
           PreparedStatement ps = cn.prepareStatement(sql);
           ps.setInt(1, idUsuario);
           resultado = ps.executeUpdate();
           //5.- Cerrar conexion
           conexionRepository.cerrarConexion();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
           conexionRepository.cerrarConexion();
           resultado=0;
       }
       return resultado;
    }
    
}
