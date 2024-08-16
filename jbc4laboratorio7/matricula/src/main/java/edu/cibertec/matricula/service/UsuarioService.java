package edu.cibertec.matricula.service;

import java.util.List;

import edu.cibertec.matricula.entity.UsuarioEntity;

public interface UsuarioService {  
    public UsuarioEntity autenticar(String user, String password);
    public List<UsuarioEntity> listarUsuarios();
}
