package edu.cibertec.cursoseguro.service;

import java.util.List;

import edu.cibertec.cursoseguro.entity.UsuarioEntity;

public interface UsuarioService {
    public UsuarioEntity autenticar (String user, String password);
    public List<UsuarioEntity> listarUsuario();
    public UsuarioEntity obtenerUsuario (Integer idUsuario);
    public void crearUsuario(UsuarioEntity usuario); 
    public void eliminarUsuario(Integer idUsuario);
}
