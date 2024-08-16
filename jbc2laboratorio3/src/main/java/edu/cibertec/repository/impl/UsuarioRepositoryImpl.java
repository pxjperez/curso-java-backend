/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.repository.impl;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
/**
 *
 * @author jpere
 */
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{

    private List<UsuarioEntity> listaUsuarios;
    public UsuarioRepositoryImpl(){
        listaUsuarios= new ArrayList<>();
        listaUsuarios.add(new UsuarioEntity(1,"JPEREZGIL","123456","JUAN CARLOS",new byte[1],"1"));
        listaUsuarios.add(new UsuarioEntity(2,"ADMIN","123456","ADMINISTRADO",new byte[1],"1"));
        listaUsuarios.add(new UsuarioEntity(3,"DANY","123456","DANIEL DIAZ",new byte[1],"1"));
        listaUsuarios.add(new UsuarioEntity(4,"MARI","123456","MARIA PEREZ",new byte[1],"1"));
    }
    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
       UsuarioEntity  resultado= null;
       List<UsuarioEntity> listaUsuariosTemp = listaUsuarios.stream().filter(u->u.getUser().equals(usuario.getUser())&&u.getPassword().equals(usuario.getPassword())).collect(Collectors.toList());
       if(listaUsuariosTemp.size()>0){
           return listaUsuariosTemp.get(0);
       }else{
           return null;
       }
    }

    @Override
    public List<UsuarioEntity> listarUsuario() {
        return listaUsuarios.stream().filter(u->u.getEstado().equals("1")).collect(Collectors.toList()); 
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return listaUsuarios.get(idUsuario-1);
    }

    @Override
    public void insertarUsuario(UsuarioEntity usuario) {
        usuario.setIdUsuario(listaUsuarios.size());
        listaUsuarios.add(usuario);
    }

    @Override
    public void actualizarUsuario(UsuarioEntity usuario) {
       listaUsuarios.set(usuario.getIdUsuario()-1, usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        UsuarioEntity usuario =listaUsuarios.get(idUsuario-1);
        usuario.setEstado("0");
        listaUsuarios.set(usuario.getIdUsuario()-1, usuario);
    }
    
}
