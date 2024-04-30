package edu.cibertec.matricula.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.matricula.entity.UsuarioEntity;
import edu.cibertec.matricula.repository.UsuarioRepository;
import edu.cibertec.matricula.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity autenticar(UsuarioEntity usuario) {
        return usuarioRepository.findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());
    }
    
}
