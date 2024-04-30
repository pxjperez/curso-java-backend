/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.repository;

import edu.cibertec.bean.Usuario;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface UsuarioDao {
    public Usuario validarLogin(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public Usuario obtenerUsuario(Integer idUsuario);
    public Integer registrarUsuario(Usuario usuario);
    public Integer actualizarUsuario(Usuario usuario);
    public Integer eliminarUsuario(Integer idUsuario);
}
