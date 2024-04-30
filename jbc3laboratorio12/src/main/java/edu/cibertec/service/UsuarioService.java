/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.entity.UsuarioEntity;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface UsuarioService {
    public UsuarioEntity validarUsuario(UsuarioEntity usuario);
    public List<UsuarioEntity>listarUsuario();
    public UsuarioEntity obtenerUsuario (Integer idUsuario);   
    public List<UsuarioEntity> listarUsuarioPorNombreApellido(String nombreApellido);
    public UsuarioEntity agregarUsuario(UsuarioEntity usuario);
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario);
    public Integer eliminarUsuario(Integer idUsuario);
}
