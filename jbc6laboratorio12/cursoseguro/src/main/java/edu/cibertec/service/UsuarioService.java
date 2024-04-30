package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioService {
    public List<UsuarioEntity> listarUsuarios();
    public void crearUsuario(UsuarioEntity usuario);
}
