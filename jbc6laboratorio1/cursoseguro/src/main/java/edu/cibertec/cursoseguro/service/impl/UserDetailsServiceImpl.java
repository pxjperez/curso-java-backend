package edu.cibertec.cursoseguro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.cibertec.cursoseguro.entity.UsuarioEntity;
import edu.cibertec.cursoseguro.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Obtener los datos del usuario desde la BD
        UsuarioEntity usuario = usuarioRepository.findByUser(username);
        //Simulo que agrego roles 
        List<GrantedAuthority> roles =  new ArrayList<>();
        //Traigo los roles de la bd
        //for
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        //roles
        //Almaceno los datos el User del padre UserDetails
        UserDetails userDetails = new User(usuario.getUser(), "{noop}"+usuario.getPassword(), roles);
        return userDetails;
    }
    
}
