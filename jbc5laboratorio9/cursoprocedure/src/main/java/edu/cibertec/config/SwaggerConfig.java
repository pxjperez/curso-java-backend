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
    public OpenAPI usersMicroserviceOpenAPI() { 
        return new OpenAPI()
                .info(new Info().title("API REST") //El titulo del api
                                 .description("DESCRIPCION DE MI API REST") //Descripcion del api
                                 .version("1.0")//Version del api
                                 .contact(new Contact().email("jperezgil@outlook.com") //Correo de contacto
                                                       .name("JPEREZGIL")) //Nombre de contacto
                                 .license(new License().name("Apache 2.0") //Licencia de contacto
                                                       .url("http://springdoc.org")));  //UrL de mi pagina                
    }
}
