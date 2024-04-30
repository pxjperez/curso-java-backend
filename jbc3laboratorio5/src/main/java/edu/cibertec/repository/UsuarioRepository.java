/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.repository;

import edu.cibertec.entity.UsuarioEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    //Por consulta DSL
    //El patron es findBy(nombre atributo 1)And(nombre atributo 2)
    public UsuarioEntity findByUserAndClave(String user, String clave);
    //Por Query Nativa
    @Query(value = "SELECT * FROM usuario WHERE usuario=:user AND clave=:clave", nativeQuery =true )
    public UsuarioEntity validarUserClave(@Param("user")String user, @Param("clave")String clave);
    //Por Query Nativa
    @Query(value = "CALL validar_usuario_clave(:user, :clave)", nativeQuery =true )
    public UsuarioEntity validarUserClaveProcedure(@Param("user")String user, @Param("clave")String clave);
    //Por Query Nativa
    @Query(value = "SELECT U FROM UsuarioEntity U WHERE U.user=:user AND U.clave=:clave", nativeQuery =false )
    public UsuarioEntity validarUserClaveNoNativa(@Param("user")String user, @Param("clave")String clave);
    
    @Query(value = "SELECT * FROM usuario WHERE nombreapellido like %:nombreapellido%", nativeQuery =true )
    public List<UsuarioEntity> listarUsuarioPorNombreApellido(@Param("nombreapellido")String nombreApellido);
    
}
