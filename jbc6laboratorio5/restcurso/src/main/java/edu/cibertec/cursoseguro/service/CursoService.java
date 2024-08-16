package edu.cibertec.cursoseguro.service;

import java.util.List;

import edu.cibertec.cursoseguro.entity.CursoEntity;

public interface CursoService {
    public List<CursoEntity> listarCursos();
    public CursoEntity obtenerCurso(Integer idCurso);
}
