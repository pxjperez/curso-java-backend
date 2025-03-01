package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.UsuarioEntity;
import io.swagger.v3.oas.annotations.tags.Tag;

@Repository
@RepositoryRestResource(path = "usuarios") //Para personalizar el nombre del recursos en el path
@Tag(name = "Usuarios", description = "API de Usuarios") //Para personalizar el nombre que aparecera en la documentacion del API con Swagger
public interface UsuarioRepository  extends JpaRepository<UsuarioEntity, Integer> {    
}
