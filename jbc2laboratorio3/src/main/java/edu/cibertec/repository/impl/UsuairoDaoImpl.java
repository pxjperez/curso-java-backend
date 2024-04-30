/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.repository.impl;

import edu.cibertec.bean.Usuario;
import edu.cibertec.repository.UsuarioDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public class UsuairoDaoImpl implements UsuarioDao{

    @Override
    public Usuario validarLogin(Usuario usuario) {
            if(usuario.getUser().equalsIgnoreCase("user") && usuario.getPassword().equalsIgnoreCase("123456")){
                usuario.setNombreCompleto("Juan Carlos");
            }else{
               usuario=null; 
            }
            return usuario;    
    }
    
}
