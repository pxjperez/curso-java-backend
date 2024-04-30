/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.config;

import javax.servlet.ServletContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 *
 * @author jpere
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = ("edu.cibertec"))
public class DispatcherServlet {
//    //Mapear las vistas que se invocan en el controlador usando el ViewResolver
//    @Bean
//    public  InternalResourceViewResolver getInternalResourceViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
    //Mapear las vistas que se invocan en el controlador usando el Thymeleaf
    @Bean
    public ServletContextTemplateResolver templateResolver(ServletContext servletContext){
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        return resolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(ServletContext servletContext){
        SpringTemplateEngine resolverEngine = new SpringTemplateEngine();
        resolverEngine.setTemplateResolver(templateResolver(servletContext));
        return resolverEngine;
    }
    @Bean
    public ThymeleafViewResolver getThymeleafViewResolver(ServletContext servletContext){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine(servletContext));
        return viewResolver;
    }
    
    //Habilitar la carga de archivos
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }
}
