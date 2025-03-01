package edu.cibertec.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("TITULO DE MI API")
                                            .description("DESCRIPCION DE MI API")
                                            .version("1.0")
                                            .contact(new Contact().email("EMAIL@EMAIL.COM")
                                                                  .name("NOMBRE DEL CONTACTO")
                                                                  .url("URL DEL CONTACTO"))
                                            .license(new License().name("LICENCIA DE MI API")
                                                                   .url("URL DE LA LICENCIA"))                      
                                            );
    }
}
