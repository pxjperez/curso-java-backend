package edu.cibertec.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.matricula.entity.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity,Integer> {
    
}
