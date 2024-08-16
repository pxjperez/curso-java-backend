/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.repository;

import edu.cibertec.entity.UsuarioEntity;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface UsuarioRepository {
    public UsuarioEntity validarUsuario(UsuarioEntity usuario);    
    public List<UsuarioEntity> listarUsuario();
    public UsuarioEntity obtenerUsuario(Integer idUsuario);
    public Integer insertarUsuario(UsuarioEntity usuario);
    public Integer actualizarUsuario(UsuarioEntity usuario);
    public Integer eliminarUsuario(Integer idUsuario);
}
