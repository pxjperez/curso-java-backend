/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.repository.impl;

import edu.cibertec.bean.Usuario;
import edu.cibertec.repository.Conexion;
import edu.cibertec.repository.UsuarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao{

    @Autowired
    private Conexion conexion;
    
    @Override
    public Usuario validarLogin(Usuario usuario) {
        try{
            //1.-Conectarce a la BD
            Connection cn = conexion.obtenerConexion();
            //2.-Definir consulta SQL
            String sql = "SELECT * FROM usuario WHERE user=? AND password=?";
            //3.-Ejecutar la consulta SQL
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ResultSet rs = ps.executeQuery();
            //4.-Almacenar en un Objeto JAVA
            usuario=null;
            while(rs.next()){
                usuario=new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setUser(rs.getString("user"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombreCompleto(rs.getString("nombreCompleto"));
            }
            //5.-Cerrar conexion
            conexion.cerrarConexion();            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            usuario=null;
        }
        return usuario;  
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = null;
        try{
            //1.-Conectarce a la BD
            Connection cn = conexion.obtenerConexion();
            //2.-Definir consulta SQL
            String sql = "SELECT * FROM usuario";
            //3.-Ejecutar la consulta SQL
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //4.-Almacenar en un Objeto JAVA
            listaUsuarios = new ArrayList<>();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setUser(rs.getString("user"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombreCompleto(rs.getString("nombreCompleto"));
               listaUsuarios.add(usuario);
            }
            //5.-Cerrar conexion
            conexion.cerrarConexion();            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            listaUsuarios=null;
        }
        return listaUsuarios;
    }

    @Override
    public Usuario obtenerUsuario(Integer idUsuario) {
        Usuario usuario = null;
        try{
            //1.-Conectarce a la BD
            Connection cn = conexion.obtenerConexion();
            //2.-Definir consulta SQL
            String sql = "SELECT * FROM usuario WHERE idusuario=?";
            //3.-Ejecutar la consulta SQL
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            //4.-Almacenar en un Objeto JAVA
            while(rs.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setUser(rs.getString("user"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombreCompleto(rs.getString("nombreCompleto"));
            }
            //5.-Cerrar conexion
            conexion.cerrarConexion();            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            usuario=null;
        }
        return usuario;  
    
    }

    @Override
    public Integer registrarUsuario(Usuario usuario) {
        Integer registros = 0;
        try{
            //1.-Conectarce a la BD
            Connection cn = conexion.obtenerConexion();
            //2.-Definir consulta SQL
            String sql = "INSERT INTO usuario(user,password,nombrecompleto) "+
                         "VALUES (?,?,?)";
            //3.-Ejecutar la consulta SQL //4.-Almacenar en un Objeto JAVA
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombreCompleto());
            registros = ps.executeUpdate();
            //5.-Cerrar conexion
            conexion.cerrarConexion();            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            registros=0;
        }
        return registros;
    }

    @Override
    public Integer actualizarUsuario(Usuario usuario) {
        Integer registros = 0;
        try{
            //1.-Conectarce a la BD
            Connection cn = conexion.obtenerConexion();
            //2.-Definir consulta SQL
            String sql = "UPDATE usuario SET user=?,password=?,nombrecompleto=? WHERE idusuario=?";
            //3.-Ejecutar la consulta SQL //4.-Almacenar en un Objeto JAVA
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombreCompleto());
            ps.setInt(4, usuario.getIdUsuario());
            registros = ps.executeUpdate();
            //5.-Cerrar conexion
            conexion.cerrarConexion();            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            registros=0;
        }
        return registros;
    }

    @Override
    public Integer eliminarUsuario(Integer idUsuario) {
        Integer registros = 0;
        try{
            //1.-Conectarce a la BD
            Connection cn = conexion.obtenerConexion();
            //2.-Definir consulta SQL
            String sql = "DELETE FROM usuario WHERE idusuario=?";
            //3.-Ejecutar la consulta SQL //4.-Almacenar en un Objeto JAVA
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            registros = ps.executeUpdate();
            //5.-Cerrar conexion
            conexion.cerrarConexion();            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            registros=0;
        }
        return registros;    
    }
    
}
