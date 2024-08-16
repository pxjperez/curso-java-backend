/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service.impl;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.repository.CursoRepository;
import edu.cibertec.service.CursoService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository cursoRepository;
    
    @Override
    public List<CursoEntity> listarCursosPorNombreCurso(String nombreCurso) {
        return cursoRepository.findByNombreCursoContainingIgnoreCase(nombreCurso);
    }

    @Override
    public List<CursoEntity> listarCursosPorNombreCursoAndAlumnosMinimo(String nombreCurso, Integer alumnosMinimo) {
        return cursoRepository.findByNombreCursoAndAlumnosMinimo(nombreCurso, alumnosMinimo);
    }

    @Override
    public List<CursoEntity> consultarPorEstado(Integer estado) {
        return cursoRepository.consultarPorEstado(estado);
    }

    @Override
    public List<CursoEntity> abiertoIncompleto() {
        return cursoRepository.abiertoIncompleto();
    }

    @Override
    public List<CursoEntity> abiertoIncompletoNativo() {
        return cursoRepository.abiertoIncompletoNativo();
    }

    @Override
    public List<CursoEntity> consultarPorFecha(Date fecha) {
        return cursoRepository.consultarPorFecha(fecha);
    }

    @Override
    public List<CursoEntity> consultarFaltantes(Integer cantidad) {
        return cursoRepository.consultarFaltantes(cantidad);
    }

    @Override
    public List<CursoEntity> consultarPorNombre(String nombre) {
        return cursoRepository.consultarPorNombre(nombre);
    }
    
}
