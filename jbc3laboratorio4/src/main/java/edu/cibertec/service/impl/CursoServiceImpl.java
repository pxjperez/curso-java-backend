/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service.impl;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.entity.UsuarioEntity;
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
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> consultarPorEstado(int estado) {
        return cursoRepository.consultarPorEstado(estado);
    }

    @Override
    public List<CursoEntity> abiertoIncompleto() {
        return cursoRepository.abiertoIncompleto();
    }

    @Override
    public List<CursoEntity> consultarPorFecha(Date fechaInicio) {
        return cursoRepository.consultarPorFecha(fechaInicio);
    }

    @Override
    public List<CursoEntity> consultarPorFaltantes(Integer cantidad) {
        return cursoRepository.consultarPorFaltantes(cantidad);
    }

    @Override
    public List<CursoEntity> consultarPorNombre(String cadena) {
        return cursoRepository.consultarPorNombre(cadena);
    }

}
