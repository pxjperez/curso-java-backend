package edu.cibertec.service.impl;

import edu.cibertec.bean.Usuario;
import edu.cibertec.repository.UsuarioDao;
import edu.cibertec.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jpere
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    @Override
    public Usuario validarLogin(Usuario usuario) {
        return usuarioDao.validarLogin(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.listarUsuarios();
    }

    @Override
    public Usuario obtenerUsuario(Integer idUsuario) {
        return usuarioDao.obtenerUsuario(idUsuario);   
    }

    @Override
    public Integer registrarUsuario(Usuario usuario) {
        return usuarioDao.registrarUsuario(usuario);  
    }

    @Override
    public Integer actualizarUsuario(Usuario usuario) {
        return usuarioDao.actualizarUsuario(usuario);  
    }

    @Override
    public Integer eliminarUsuario(Integer idUsuario) {
        return usuarioDao.eliminarUsuario(idUsuario);  
    }
    
}
