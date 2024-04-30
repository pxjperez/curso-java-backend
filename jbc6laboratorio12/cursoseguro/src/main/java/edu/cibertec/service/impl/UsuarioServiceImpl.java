package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
	private BCryptPasswordEncoder codificar;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void crearUsuario(UsuarioEntity usuario) {
        usuario.setPassword(codificar.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }
    
}
