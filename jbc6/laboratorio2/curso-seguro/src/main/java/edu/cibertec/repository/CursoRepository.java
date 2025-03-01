package edu.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.entity.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
    public List<CursoEntity> findByEstado(Integer estado);
}
