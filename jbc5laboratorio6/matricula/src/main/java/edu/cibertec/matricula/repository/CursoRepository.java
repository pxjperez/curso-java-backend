package edu.cibertec.matricula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import edu.cibertec.matricula.entity.CursoEntity;

@Repository
@RepositoryRestResource(collectionResourceRel = "cursoRepository",path="cursoRepository")
public interface CursoRepository extends JpaRepository<CursoEntity,Integer>{    
    public List<CursoEntity> findAllByEstadoNot(int estado);
}
