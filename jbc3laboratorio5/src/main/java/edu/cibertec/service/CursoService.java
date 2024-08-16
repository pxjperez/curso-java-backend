/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.entity.CursoEntity;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jpere
 */
public interface CursoService {
    public List<CursoEntity> listarCursosPorNombreCurso(String nombreCurso);
    public List<CursoEntity> listarCursosPorNombreCursoAndAlumnosMinimo(String nombreCurso, Integer alumnosMinimo);
    public List<CursoEntity> consultarPorEstado(Integer estado);
    public List<CursoEntity> abiertoIncompleto();
    public List<CursoEntity> abiertoIncompletoNativo();
    public List<CursoEntity> consultarPorFecha(Date fecha);
    public List<CursoEntity> consultarFaltantes(Integer cantidad);
    public List<CursoEntity> consultarPorNombre(String nombre);
}
