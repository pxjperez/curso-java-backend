package edu.cibertec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

    //Este Bean gestiona de manera automatica la autenticacion
     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
         return authenticationConfiguration.getAuthenticationManager();
     }

    //Este Bean gestiona la autorizacion
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {       
        http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(
                authz -> {
                 //Desde aqui se puede controlar la autorizacion del usuaio 
                 //Aqui se podria agregar una lista de accesos en funcion al rol (Usando un FOR)
                 authz.requestMatchers(HttpMethod.GET,"/api/v1/cursos/*").hasRole("ADMIN");
                 authz.requestMatchers(HttpMethod.GET,"/api/v1/cursos").permitAll();
                }    
            )
            .httpBasic(Customizer.withDefaults()); //Le especifico que para el consumo de un servicio rest debo de usar una autenticacion basica
        return http.build();
    }

    //Este Bean gestiona la encriptacion de las contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
}
