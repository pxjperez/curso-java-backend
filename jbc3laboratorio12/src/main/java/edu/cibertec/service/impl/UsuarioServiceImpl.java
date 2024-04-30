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
import org.springframework.transaction.annotation.Transactional;

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
       return usuarioRepository.findByUserAndClave(usuario.getUser(), usuario.getClave());
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
    public List<UsuarioEntity> listarUsuarioPorNombreApellido(String nombreApellido) {
        return usuarioRepository.listarUsuarioPorNombreApellido(nombreApellido);
    }

    @Override
    @Transactional
    public UsuarioEntity agregarUsuario(UsuarioEntity usuario) {
        UsuarioEntity resultado=null;
        try{
            resultado=usuarioRepository.save(usuario);
        }catch(Exception ex){
            resultado=null;
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @Override
    @Transactional
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        UsuarioEntity resultado=null;
        try{
            resultado=usuarioRepository.save(usuario);
        }catch(Exception ex){
            resultado=null;
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @Override
    public Integer eliminarUsuario(Integer idUsuario) {
        Integer resultado = 0;
        try{
            usuarioRepository.deleteById(idUsuario);
            resultado=1;
        }catch(Exception ex){
            resultado=0;
        }
        return resultado;
    }
    
}
