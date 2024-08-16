package edu.cibertec.cursoseguro.security;

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
    //Habilita la autenticaion
    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
    //Controllar la autorizacion
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.disable())
            .authorizeHttpRequests(
                authz->{
                    //Para agregar un solo rol
                    //authz.requestMatchers("/admin/**").hasRole("ADMIN");
                    //Para agregar multiples roles
                    authz.requestMatchers("/admin/**").hasAnyRole("ADMIN","USER");
                    authz.requestMatchers("/css/**").permitAll();
                    authz.requestMatchers("/fonts/**").permitAll();
                    authz.requestMatchers("/images/**").permitAll();
                    authz.requestMatchers("/js/**").permitAll();
                    authz.requestMatchers("/vendor/**").permitAll();
                    authz.anyRequest().authenticated();
                }
            )
            .formLogin(
                login->{
                    login.loginPage("/login").permitAll();
                    login.usernameParameter("txtUserName");
                    login.passwordParameter("txtPassword");
                }
            );
        return http.build();
    }

    //Para gestionar la encriptacion de contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
