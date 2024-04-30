package edu.cibertec.service.impl;

import edu.cibertec.bean.Usuario;
import edu.cibertec.repository.UsuarioDao;
import edu.cibertec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jpere
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    @Override
    public Usuario validarLogin(Usuario usuario) {
        return usuarioDao.validarLogin(usuario);
    }
    
}
