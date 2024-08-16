package edu.cibertec.cursoseguro.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cibertec.cursoseguro.entity.UsuarioEntity;
import edu.cibertec.cursoseguro.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/security")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping()
    public String autenticacion(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        InputStream body = req.getInputStream();

        UsuarioEntity user =  new ObjectMapper().readValue(body, UsuarioEntity.class);
            
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUser(), user.getPassword(), Collections.emptyList()));

            JwtUtil.generarToken(res, auth.getName());

            //return res.getHeader("Authorization"); //No  deberia de hacerce;

            return "";
    }
    
    
}
