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
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.validarUsuario(usuario.getUser(), usuario.getPassword());
    }

    @Override
    public List<UsuarioEntity> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

    @Override
    public Integer insertarUsuario(UsuarioEntity usuario) {
        usuario = usuarioRepository.save(usuario);
        if (usuario != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer actualizarUsuario(UsuarioEntity usuario) {
        usuario = usuarioRepository.save(usuario);
        if (usuario != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer eliminarUsuario(Integer idUsuario) {
        try {
            usuarioRepository.deleteById(idUsuario);
            return 1;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

}
