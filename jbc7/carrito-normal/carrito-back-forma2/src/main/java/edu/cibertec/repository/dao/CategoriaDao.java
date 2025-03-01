package edu.cibertec.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.entity.CategoriaEntity;

public interface CategoriaDao extends JpaRepository<CategoriaEntity, Integer> {

}