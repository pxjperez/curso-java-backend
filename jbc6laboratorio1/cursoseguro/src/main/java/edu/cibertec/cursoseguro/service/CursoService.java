package edu.cibertec.cursoseguro.service;

import java.util.List;

import edu.cibertec.cursoseguro.entity.CursoEntity;

public interface CursoService {
    public List<CursoEntity>listarCursos();
    public CursoEntity obtenerCurso(Integer idCurso);
    public void insertarCurso(CursoEntity curso);
    public void actualizarCurso(CursoEntity curso);
    public void eliminarCurso(Integer idCurso);
}
