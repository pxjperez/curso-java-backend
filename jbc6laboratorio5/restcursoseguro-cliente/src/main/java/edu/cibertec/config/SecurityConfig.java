package edu.cibertec.config;

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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.cibertec.filter.JwtFilter;
import edu.cibertec.filter.LoginFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

   

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        List<AuthenticationProvider> providers =  List.of(authProvider);
        return new ProviderManager(providers);
    }

    //Este Bean gestiona la autorizacion
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {       
        //No olvidar que para los servicios rest el manejo de las autenticaciones son sin estado (No se almacenan en el srvidor)
            http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            http.csrf(csrf -> csrf.disable())
            //La forma mas utilizadas es esta:
            .authorizeHttpRequests(
                authz -> {
                authz.requestMatchers("/api/v1/security").permitAll(); //Permitimos el acceso a todas las peticiones   
                 authz.requestMatchers("/login").permitAll(); //Permitimos el acceso a todas las peticiones
                 authz.anyRequest().authenticated(); //Cualquier otra peticion requiere autenticacion
                }    
            )
            //.httpBasic(Customizer.withDefaults());
            // Las peticiones /login pasarán previamente por este filtro
            .addFilterBefore(new LoginFilter("/api/v1/security", authenticationManager()),UsernamePasswordAuthenticationFilter.class)
            // Las demás peticiones pasarán por este filtro para validar el token
            .addFilterBefore(new JwtFilter(),UsernamePasswordAuthenticationFilter.class);

            return http.build();
    }

    //Este Bean gestiona la encriptacion de las contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
}
