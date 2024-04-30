package edu.cibertec.curso.service;



import java.util.List;

import edu.cibertec.curso.entity.UsuarioEntity;

public interface UsuarioService {

    public List<UsuarioEntity> listarUsuarios();
    public UsuarioEntity obtenerUsuario(Integer idUsuario);

}
