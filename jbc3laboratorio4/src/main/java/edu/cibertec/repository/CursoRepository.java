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
public interface CursoRepository extends JpaRepository<CursoEntity, Integer>{
    //Consulta por nombre de curso
    public List<CursoEntity> findByNombreCursoContainingIgnoreCase(String nombreCurso);//Aqui no se necesita agregar un query por que el framework entiende el lenguaje
    
    //Consulta por nombre de curso y alumnos minimo
    public List<CursoEntity> findByNombreCursoAndAlumnosMinimo(String nombreCurso, Integer alumnosMinimo); //Aqui no se necesita agregar un query por que el framework entiende el lenguaje
    
    //Consulta de cursos por estado (Por posicion)
    @Query("SELECT c FROM CursoEntity c WHERE c.estado=?1")
    public List<CursoEntity> consultarPorEstado(Integer estado);//El parametro de entrada esta dado por la posicion del signo de pregunta
    
    //Consulta de curso abiertos pero aun no completros
    public List<CursoEntity> abiertoIncompleto();//El framwork trae la consulta del NamedQuery definido en la entidad
    
    //Consulta de curso abiertos pero aun no completros nativo
    public List<CursoEntity> abiertoIncompletoNativo();//El framwork trae la consulta del NamedNativeQuery definido en la entidad
    
    //Consulta de cursos despues de una fecha x (Por parametro)
    @Query("SELECT c FROM CursoEntity c WHERE c.fechaInicio>=:fecha")
    public List<CursoEntity> consultarPorFecha(@Param("fecha")Date fecha);
    
    //Consulta de cursos a los que les falta x numero de alumnos para llenarce
    @Query(value = "SELECT * FROM curso WHERE (alumnosmin - alumnosact)=:cantidad", nativeQuery = true)
    public List<CursoEntity> consultarFaltantes(@Param("cantidad")Integer cantidad);
    
    //Consulta de cursos por nombre invocando a un stored procedure
    @Query(value = "CALL Curso_Por_Nombre(:nombre)" , nativeQuery =true)
    public List<CursoEntity> consultarPorNombre(@Param("nombre")String nombre);
    
    
    
}
