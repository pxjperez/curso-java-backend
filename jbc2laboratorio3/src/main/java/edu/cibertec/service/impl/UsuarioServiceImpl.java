/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service.impl;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
       return usuarioRepository.validarUsuario(usuario);
    }

    @Override
    public List<UsuarioEntity> listarUsuario() {
        return usuarioRepository.listarUsuario();
    }
    
    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.obtenerUsuario(idUsuario);
    }

    @Override
    public void insertarUsuario(UsuarioEntity usuario) {
        usuarioRepository.insertarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(UsuarioEntity usuario) {
         usuarioRepository.actualizarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuarioRepository.eliminarUsuario(idUsuario);
    }
    
}
