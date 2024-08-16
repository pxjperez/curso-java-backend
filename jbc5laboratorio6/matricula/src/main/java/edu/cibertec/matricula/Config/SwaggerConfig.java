package edu.cibertec.matricula.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI usersMicoservicesOpenAPI(){
        return new OpenAPI().info(
                                    new Info()
                                        .title("MATRICULA API")
                                        .description("API para matricula de alumnos")
                                        .version("1.0.0")
                                        .contact(new Contact().name("JUAN CARLOS PEREZ GIL")
                                                            .url("https://www.linkedin.com/in/jperezgi/")
                                                            .email("jperezgil@outlook.com")
                                                )  
                                        .license( new License().name("Apache License Version 2.0")
                                                            .url("http://www.apache.org/licenses/LICENSE-2.0.html")
                                                )
        
                                 );
    }
}
