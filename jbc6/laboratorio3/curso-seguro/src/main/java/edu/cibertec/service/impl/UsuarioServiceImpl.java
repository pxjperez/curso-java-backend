package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findByEstado(1);
    }

    @Override
    public UsuarioEntity obtenerUsuario(int idUsuario) {        
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity eliminarUsuario(int idUsuario) {
        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            usuario.setEstado(0);
            usuarioRepository.save(usuario);
        }  
        return usuario;
    }
    
}
