package edu.cibertec.cursoseguro.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true,jsr250Enabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true) (Anotacion deprecada)
public class SecurityConfig {
    //Habilita la autenticaion
    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
    //Controllar la autorizacion (Solo esta parte cambia cuando voy a utilizar seguridad en un API)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //Esta linea permite asegurar que no se van a guardar en memoria las sesiones 
        http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(csrf->csrf.disable())
            .httpBasic(Customizer.withDefaults());//Habilita la configuracion de la seguridad del API
        return http.build();
    }

    //Para gestionar la encriptacion de contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
