package edu.cibertec.curso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.curso.entity.UsuarioEntity;
import edu.cibertec.curso.repository.UsuarioRepository;
import edu.cibertec.curso.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }
    
    
}
