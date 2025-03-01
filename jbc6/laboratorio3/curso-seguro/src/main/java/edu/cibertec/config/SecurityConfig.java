package edu.cibertec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //Habilita la autenticacion de Spring Security
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Controla la autorizacion
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Esta primera linea nos va a permitir asegurar que los datos de la sesion no se guarden en el servidor
        http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(c->c.disable())
            .authorizeHttpRequests(autorizacion->{
                //Logica de la autoriazacion
                //Acceso a todo
                //Xxxx
                //Acceso con un rol especifico
                //Traer los roles  + las url de acceso
                //Lista de URL que le pertenecen a un ROL
                //For a la lista de URL y le asigno el rol
                autorizacion.requestMatchers("/api/v1/usuarios/**").hasRole("ADMIN");
                //Acceso a cualquier usuario autenticado
                autorizacion.anyRequest().authenticated();
            }
            )
            .httpBasic(Customizer.withDefaults()); //Esta linea remplaza a formLogin()
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
