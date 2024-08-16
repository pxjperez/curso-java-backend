package edu.cibertec.matricula.service.impl;

import java.util.List;

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
    public UsuarioEntity autenticar(String user, String password) {
        return usuarioRepository.findByUserAndPassword(user, password);
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    
}
