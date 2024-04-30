/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.repository;

import edu.cibertec.entity.CursoEntity;
import java.util.Date;
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
public interface CursoRepository extends JpaRepository<CursoEntity,Integer>{
    //Consulta de cursos por estado de forma no nativa
    @Query("SELECT c FROM CursoEntity c WHERE c.estado=?1") //?1 esta forma respeta el orden de como se ingresa los parametros de entrada
    public List<CursoEntity> consultarPorEstado(Integer estado);
    //Consulta de los cursos biertos no completos de manera directa con el namedQuery
    //Trae la consulta desde el NamedQuery de la entidad
    public List<CursoEntity> abiertoIncompleto();
    //Consulta de cursos por fecha de inicio de forma nativa
    @Query(value = "SELECT * FROM curso WHERE fechaInicio>=?1",nativeQuery =true ) 
    public List<CursoEntity> consultarPorFecha(Date fechaInicio);
    //Consulta por numero de alumnos que falta completar para llenar el curso
    @Query(value = "SELECT * FROM curso WHERE (alumnosMin-alumnosAct)>=:cantidad",nativeQuery =true ) 
    public List<CursoEntity> consultarPorFaltantes(@Param("cantidad")Integer cantidad);
    //Consulta de cursos por su nombre 
    //Llamando a un Store procedure
    @Query(value = "CALL Curso_Por_Nombre(:cadena)",nativeQuery =true ) 
    public List<CursoEntity> consultarPorNombre(@Param("cadena")String cadena);    
}
