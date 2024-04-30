package edu.cibertec.filter;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.util.JwtUtil;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import jakarta.servlet.FilterChain;

//Genera el Token
public class LoginFilter extends AbstractAuthenticationProcessingFilter {
    
    
    public LoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {

        // obtenemos el body de la petición que debe venir en formato JSON
        InputStream body = req.getInputStream();

        // Asumimos que el body tendrá el siguiente JSON  {"usuario":"ask", "clave":"123"}
        // Realizamos un mapeo a nuestra clase UsuarioEntity para almacenar allí los datos
        UsuarioEntity user = new ObjectMapper().readValue(body, UsuarioEntity.class);

        // Finalmente autenticamos
        // Spring comparará el user/password recibidos
        // contra el que definimos en la clase SecurityConfig
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUser(),
                        user.getPassword(),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        // Si la autenticación fue exitosa, agregamos el token a la respuesta
        JwtUtil.generarToken(res, auth.getName());
    }

}