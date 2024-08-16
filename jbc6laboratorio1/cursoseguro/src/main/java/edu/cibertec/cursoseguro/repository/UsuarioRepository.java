package edu.cibertec.cursoseguro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.cursoseguro.entity.UsuarioEntity;
import java.util.List;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer> {
    public UsuarioEntity findByUser(String usuario);
    
}
