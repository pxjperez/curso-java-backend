package edu.cibertec.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Date;

import static java.util.Collections.emptyList;

import java.security.Key;

public class JwtUtil {
    // Clave secreta para firmar el JWT
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    // Método para crear el JWT y enviarlo al cliente en el header de la respuesta
    public static void generarToken(HttpServletResponse res, String username) {
        String token = Jwts.builder()
                // Se agrega los datos del Payload
                .setSubject(username)
                // Se asigna un tiempo de expiración de 1 minuto
                .setExpiration(new Date(System.currentTimeMillis() + 60000))
                // Hash con el que firmaremos la clave
                .signWith(SECRET_KEY)
                .compact();
        //agregamos al encabezado el token
        res.addHeader("Authorization", "Bearer " + token);        
    }

    // Método para validar el token enviado por el cliente
    public static Authentication leerToken(HttpServletRequest request) {
        String user;
        // Obtenemos el token que viene en el encabezado de la petición
        String token = request.getHeader("Authorization");
        // si hay un token presente, entonces se valida
        if (token != null) {
            
            try{
                user=Jwts.parser()               
                         // Hash con el que firmaremos la clave     
                         .setSigningKey(SECRET_KEY).build()
                         // Token
                         .parseClaimsJws(token.replace("Bearer", "").trim()) //este método es el que valida
                         .getBody()
                         .getSubject();
            }catch(Exception ex){
                System.out.println("Ocurrio un error en:"+ex.getMessage());
                user=null;
            }            
            // Recordamos que para las demás peticiones que no sean /login
            // no requerimos una autenticación por username/password 
            // por ese motivo podemos devolver un UsernamePasswordAuthenticationToken sin password
            return user != null
                    ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
                    : null;
        }
        return null;
    }
}
