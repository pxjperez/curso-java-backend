package edu.cibertec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
        http.csrf(c->c.disable())
            .authorizeHttpRequests(autorizacion->{
                //Logica de la autoriazacion
                //Acceso a todo
                autorizacion.requestMatchers("/css/**").permitAll();
                autorizacion.requestMatchers("/fonts/**").permitAll();
                autorizacion.requestMatchers("/images/**").permitAll();
                autorizacion.requestMatchers("/js/**").permitAll();
                autorizacion.requestMatchers("/vendor/**").permitAll();
                //Acceso con un rol especifico
                //Traer los roles  + las url de acceso
                //Lista de URL que le pertenecen a un ROL
                //For a la lista de URL y le asigno el rol
                autorizacion.requestMatchers("/admin/**").hasRole("ADMIN");
                //Acceso a cualquier usuario autenticado
                autorizacion.anyRequest().authenticated();
            }
            )
            .formLogin(login->{
                //Logica del login
                login.loginPage("/login").permitAll();
                login.usernameParameter("txtUser");
                login.passwordParameter("txtPassword");
            });

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
