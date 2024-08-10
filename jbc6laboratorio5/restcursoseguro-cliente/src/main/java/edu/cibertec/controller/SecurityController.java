package edu.cibertec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/security")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping()
    public String authentication(HttpServletRequest req, HttpServletResponse res) {
        try {
            // obtenemos el body de la petición que debe venir en formato JSON
        InputStream body = req.getInputStream();
        // Asumimos que el body tendrá el siguiente JSON  {"usuario":"ask", "clave":"123"}
        // Realizamos un mapeo a nuestra clase UsuarioEntity para almacenar allí los datos
        UsuarioEntity user = new ObjectMapper().readValue(body, UsuarioEntity.class);

        // Finalmente autenticamos
        // Spring comparará el user/password recibidos
        // contra el que definimos en la clase SecurityConfig
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUser(),
                        user.getPassword(),
                        Collections.emptyList()
                )

        );
        JwtUtil.generarToken(res, user.getUser());
        } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
        }
        
        return "";
    }
    
}
