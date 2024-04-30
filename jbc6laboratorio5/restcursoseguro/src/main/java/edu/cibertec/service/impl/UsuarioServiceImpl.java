package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Integer eliminarUsuario(Integer idUsuario) {
        Integer resultado=0;
        try {
            usuarioRepository.deleteById(idUsuario); 
            resultado=1;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado=0;
        }              
        return resultado; 
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }
    
}
