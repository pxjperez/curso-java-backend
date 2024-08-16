package edu.cibertec.cursoseguro.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true,jsr250Enabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true) (Anotacion deprecada)
public class SecurityConfig {

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    //Habilita la autenticaion
    @Bean
    public AuthenticationManager authenticationManager () throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Controllar la autorizacion (Solo esta parte cambia cuando voy a utilizar seguridad en un API)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //Esta linea permite asegurar que no se van a guardar en memoria las sesiones 
        http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(csrf->csrf.disable())
           .authorizeHttpRequests(
              auth -> {
                    auth.requestMatchers("/api/v1/security").permitAll();
                    auth.anyRequest().authenticated();
              }
           )
           .addFilterBefore(new GenerarToken("/api/v1/security", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
           .addFilterBefore(new LeerToken(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    //Este Bean gestiona la encriptacion de las contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
}
