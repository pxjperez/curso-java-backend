package edu.cibertec.matricula.config;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "edu.cibertec.matricula")
@EnableJpaRepositories(basePackages = "edu.cibertec.matricula.repository")
@EntityScan(basePackages = "edu.cibertec.matricula.entity")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MatriculaApplication { 
    public static void main(String[] args) {
        SpringApplication.run(MatriculaApplication.class, args);
    }
 
}