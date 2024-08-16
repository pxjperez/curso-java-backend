/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.config;


import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
@EnableJpaRepositories(basePackages = "edu.cibertec.repository")
@EnableTransactionManagement
public class DispatcherServlet implements WebMvcConfigurer{
    //CONFIGURACION DE THYMELEAF - INICIO
    @Bean
    public ServletContextTemplateResolver templateResolver (ServletContext servletContext){
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(ServletContext servletContext){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver(servletContext));
        return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(ServletContext servletContext){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine(servletContext));
        return resolver;
    }
    //CONFIGURACION DE THYMELEAF - FIN
    
    //CONFIGURACION DE CARGA DE ARCHIVOS - INICIO
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }
    //CONFIGURACION DE CARGA DE ARCHIVOS - FIN
    
    //CONFIGURACION A LA BD - INICIO
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //AQUI INGRESAR LOS DATOS DE SU MOTOR DE BD
        String host = "localhost";//HOST O IP de la BD
        String port = "3306";//PUERTO que usa la BD
        String bd = "matricula"; //BD que se usara 
        String user = "root"; //Usuario de la BD
        String password = "root"; //Contraseña de la BD
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //CAMBIA SEGUN TU MOTOR DE BD       
        dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/" + bd);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setGenerateDdl(false);// Que no me genere lo scripts de BD DDL
        hibernateJpaVendorAdapter.setShowSql(true);//Habilitando la sintaxis SQL
        //AQUI INGRESAR EL DIALETO QUE VA A UTILIZAR EN EL ACCESO A DATOS
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect"); //CAMBIA SEGUN TU MOTOR DE BD
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        //AQUI ESPECIFICAMOS EL PAQUETE EN DONDE ESTAN LAS CLASES MAPEADAS DE MANERA RELACIONAL A LA BD
        entityManagerFactory.setPackagesToScan("edu.cibertec.entity"); //Escanea todas las clases que estan en el pauete entity
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
    //CONFIGURACION A LA BD - FIN
    
    //CONFIGURACION DE LOS ARCHIVOS ESTATICOS - INICIO 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**") // URL que quieres usar para acceder a tus archivos CSS
                .addResourceLocations("/static/"); // Ruta en la que se encuentran tus archivos CSS dentro de tu proyecto
    }
    //CONFIGURACION DE LOS ARCHIVOS ESTATICOS - FIN
}
