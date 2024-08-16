package edu.cibertec.apimatricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.apimatricula.entity.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity,Integer> {
    
}
