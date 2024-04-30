package edu.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Configuration //Para especificar que esta clase es una clase de configuracion
//@EnableWebMvc // Para especificar los beans  para el manejo del MVC de manera personalizada
//@Componentscan
public class AppConfig {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}