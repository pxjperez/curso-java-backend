package edu.cibertec.cursoseguro.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import edu.cibertec.cursoseguro.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LeerToken extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {            
            Authentication authentication = JwtUtil.leerToken((HttpServletRequest) request);
            //if(authentication != null) { // Pueden utilizarlo para dar un respuesta 200  al usuario sin que sea la correcta
                SecurityContextHolder.getContext().setAuthentication(authentication);
                chain.doFilter(request, response);
            //}
    }
    
}
