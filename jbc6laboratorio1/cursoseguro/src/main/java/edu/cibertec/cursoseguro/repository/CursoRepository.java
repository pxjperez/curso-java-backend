package edu.cibertec.cursoseguro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.cursoseguro.entity.CursoEntity;

@Repository
public interface CursoRepository  extends JpaRepository<CursoEntity, Integer>{
    
}
