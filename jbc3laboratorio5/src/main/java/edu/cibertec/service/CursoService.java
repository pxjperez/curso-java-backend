/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.entity.CursoEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jpere
 */
public interface CursoService {
    public List<CursoEntity> consultarPorEstado(int estado);
    public List<CursoEntity> abiertoIncompleto();
    public List<CursoEntity> consultarPorFecha(Date fechaInicio);
    public List<CursoEntity> consultarPorFaltantes(Integer cantidad);
    public List<CursoEntity> consultarPorNombre(String cadena);  
}
