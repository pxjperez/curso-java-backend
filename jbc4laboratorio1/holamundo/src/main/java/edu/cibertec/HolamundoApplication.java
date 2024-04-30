package edu.cibertec;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import edu.cibertec.service.HolaMundoService;

@SpringBootApplication
 //@Configuration // Indica que la clase es una clase de configuracion
 //@EnableAutoConfiguration // Me permite especificar que cosas quiero que se cargen por defecto Ejemplo:  @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
 //@ComponentScan // Me permite especificar donde quiero que me mapee los Beans por Ejemeplo: @ComponentScan(basePackages = ("edu.cibertec")) 
public class HolamundoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HolamundoApplication.class, args);
	}
	@Autowired
	private HolaMundoService holaMundoService;

	@Override
	public void run(String... args) throws Exception {
		holaMundoService.saludar();
	}

	@Bean
	public CommandLineRunner  commandLineRunner(ApplicationContext ctx) {
		return args->{
			System.out.println("Inspeccinando los elementos cargados en spring boot");
			String[] beansNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beansNames);
			for(String name: beansNames){
			  System.out.println(name);
			}
		};
	}

}
