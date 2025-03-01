package edu.cibertec.service.impl;

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

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1. Obetner los datos de la BD
        UsuarioEntity usuario = usuarioRepository.findByUser(username);
        //2.-Obtener los roles del usuario
        List<GrantedAuthority> roles = new ArrayList();
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }else{
            //Aqui puedo agregar la logica para traer los roles de la BD
            //Todos los roles que configures debe de inicializarce con "ROLE_"+nombre del rol
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        //3.- Almacenar los datos en el User details
        //UserDetails userDatails = new User(usuario.getUser(), "{noop}"+usuario.getPassword(), roles); //"{noop}" deshabilitamos el encriptado de la contraseña
        UserDetails userDatails = new User(usuario.getUser(), usuario.getPassword(), roles);
        return userDatails;
    }

   
    
}
