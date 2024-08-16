package edu.cibertec.apimatricula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI(){
        return new OpenAPI().info(new Info().title("TITULO API REST")
                                            .description("DESCRIPCION DE MI API REST")
                                            .version("V1")
                                            .contact(new Contact().email("USUARIO@EMAIL.COM")
                                                                  .name("USUARIO")
                                                    )
                                            .license(new License().name("APACHE 2.0")
                                                                  .url("http://www.opensource.org/licenses/apache2.html")
                                                    )
                                 
                                 );
    }
}
