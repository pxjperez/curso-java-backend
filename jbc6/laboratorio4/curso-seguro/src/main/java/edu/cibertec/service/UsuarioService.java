package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioService {
    public List<UsuarioEntity> listarUsuarios();
    public UsuarioEntity obtenerUsuario(int idUsuario);
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario);
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario);
    public UsuarioEntity eliminarUsuario(int idUsuario);
}
