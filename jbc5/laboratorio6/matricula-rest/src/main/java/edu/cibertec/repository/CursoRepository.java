package edu.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.CursoEntity;

@Repository
//@RepositoryRestResource(path = "cursos")//Para personalizar el nombre del recursos en el path
public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {  
 
    public List<CursoEntity> findByEstado(Integer estado);
    
}
