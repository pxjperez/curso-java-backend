package edu.cibertec.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
@EnableMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private AuthenticationConfiguration authConfig;
    
    //Configura la Autenticacion
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authConfig.getAuthenticationManager();
    }


    //Controla la autorizacion
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Esta primera linea nos va a permitir asegurar que los datos de la sesion no se guarden en el servidor
        http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(c->c.disable())
            .authorizeHttpRequests(autorizacion->{
                //autorizacion.requestMatchers("/api/v1/usuarios/**").hasRole("ADMIN");
                autorizacion.requestMatchers("/api/v1/security").permitAll();
                autorizacion.anyRequest().authenticated();
            }
            )
            .addFilterBefore(new LoginFilter("/api/v1/security",authenticationManagerBean()), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
