package edu.cibertec.matricula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.matricula.entity.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity,Integer>{    
    public List<CursoEntity> findAllByEstadoNot(int estado);
}
