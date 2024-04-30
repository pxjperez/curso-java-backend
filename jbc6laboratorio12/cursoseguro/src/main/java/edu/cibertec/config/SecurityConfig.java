package edu.cibertec.config;

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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import edu.cibertec.service.impl.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
////De fine el meto de seguridad de la aplicacion
// @EnableMethodSecurity(
//         //securedEnabled = true,
//         //jsr250Enabled =true,
//         prePostEnabled = true)
public class SecurityConfig  {
    
    @Autowired
    private UserDetailsService userDetailsService; 
    
    //Metodo 1 - Inicio
    //@Bean
    //public AuthenticationManager authenticationManager() throws Exception {
    //    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    //    authProvider.setUserDetailsService(userDetailsService);
    //    List<AuthenticationProvider> providers =  List.of(authProvider);
    //    return new ProviderManager(providers);
    //}
    // Metodo 1 - Fin
    // Metodo 2 - Inicio
     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
         return authenticationConfiguration.getAuthenticationManager();
     }
    // Metodo 2 - Inicio
    ////
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {       
        //SOLO PARA SERVICIOS REST http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //No olvidar que para los servicios rest el manejo de las autenticaciones son sin estado (No se almacenan en el srvidor)
        //http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(
                authz -> {
                 //Aqui va la lista de accesos en funcion al rol 
                 authz.requestMatchers("/cursoGrabar").hasRole("ADMIN");
                 authz.requestMatchers("/cursoEliminar").hasRole("ADMIN");
                 authz.requestMatchers("/css/**").permitAll();   
                 authz.requestMatchers("/fonts/**").permitAll();
                 authz.requestMatchers("/images/**").permitAll();
                 authz.requestMatchers("/js/**").permitAll();
                 authz.requestMatchers("/vendor/**").permitAll();
                 authz.anyRequest().authenticated();   
                }    
            ).formLogin(
                login->{
                    //Aqui va la configuracion de la pagina de login personalizada
                    login.loginPage("/login").permitAll();
                    //Aqui puedo personalizar los parametros de entrada de la vista
                    login.usernameParameter("txtUsername");
                    login.passwordParameter("txtPassword");
                }
            );                                            
        //SOLO PARA SERVICIOS REST .httpBasic(Customizer.withDefaults());
        //.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }

}

