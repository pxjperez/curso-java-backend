package edu.cibertec.apimatricula.service;

import java.util.List;

import edu.cibertec.apimatricula.entity.CursoEntity;

public interface CursoService {
    public List<CursoEntity> listarCursos();
    public CursoEntity obtenerCurso(Integer idCurso);
    public CursoEntity registrarCurso(CursoEntity curso);
    public CursoEntity actualizarCurso(CursoEntity curso);
    public void eliminarCurso(Integer idCurso);
}
