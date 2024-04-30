package edu.cibertec.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.curso.entity.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity,Integer> {
    
}
