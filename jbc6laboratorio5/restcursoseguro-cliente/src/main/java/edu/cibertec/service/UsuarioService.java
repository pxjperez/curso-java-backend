package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioService{
    
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario);
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario);
    public Integer eliminarUsuario(Integer idUsuario);
    public List<UsuarioEntity> listarUsuarios();
    public UsuarioEntity obtenerUsuario(Integer idUsuario);
    
}
