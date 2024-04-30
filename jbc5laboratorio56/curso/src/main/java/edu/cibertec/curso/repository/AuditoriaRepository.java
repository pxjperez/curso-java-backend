package edu.cibertec.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import edu.cibertec.curso.entity.AuditoriaEntity;

@Repository
//@RepositoryRestResource(path = "auditoria") //Recomienda su uso para pruebas de concepto
public interface AuditoriaRepository extends JpaRepository<AuditoriaEntity,Integer> {
    
}
