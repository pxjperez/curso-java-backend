package edu.cibertec.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.curso.entity.AuditoriaEntity;

@Repository
public interface AuditoriaRepository extends JpaRepository<AuditoriaEntity,Integer> {
    
}
