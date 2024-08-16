/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.repository;

import edu.cibertec.entity.UsuarioEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
//@RepositoryDefinition(domainClass =UsuarioEntity.class, idClass = Integer.class)
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
    
    @Query(value = "SELECT * FROM usuario WHERE usuario=?1 AND clave=?2", nativeQuery = true)
    public UsuarioEntity validarUsuario(String user, String password); 
    
    public UsuarioEntity findByUserAndPassword(String user, String password); //SELECT * FROM usuario WHERE usuario=?1 AND clave=?2 
    
    public List<UsuarioEntity> findByEstado(Integer estado);//SELECT * FROM USUARIO WHERE ESTADO=?1
    
}
