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
import org.springframework.data.domain.Pageable;
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
        return usuarioRepository.findByUserAndPassword(usuario.getUser(), usuario.getPassword());
    }

    @Override
    public List<UsuarioEntity> listarUsuario() {
        return usuarioRepository.findByEstado(1);
    }

    @Override
    public List<UsuarioEntity> listarUsuario(Pageable page) {
        return usuarioRepository.findByEstado(1,page);
    }
    
    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

    @Override
    public Integer insertarUsuario(UsuarioEntity usuario) {
        Integer resultado = 0;
        usuario = usuarioRepository.save(usuario);
        if (usuario != null) {
            resultado = 1;
        } else {
            resultado = 0;
        }
        return resultado;
    }

    @Override
    public Integer actualizarUsuario(UsuarioEntity usuario) {
        Integer resultado = 0;
        usuario = usuarioRepository.save(usuario);
        if (usuario != null) {
            resultado = 1;
        } else {
            resultado = 0;
        }
        return resultado;
    }

    @Override
    public Integer eliminarUsuario(Integer idUsuario) {
        Integer resultado = 0;
        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).get();
        usuario.setEstado(0);
        usuario = usuarioRepository.save(usuario);
        if (usuario != null) {
            resultado = 1;
        } else {
            resultado = 0;
        }
        return resultado;
    }

}
