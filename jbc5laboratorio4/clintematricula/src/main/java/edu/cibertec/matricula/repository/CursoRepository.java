package edu.cibertec.matricula.repository;

import java.util.List;

import edu.cibertec.matricula.entity.CursoEntity;

public interface CursoRepository {
    public List<CursoEntity> listarCursos();
    public CursoEntity obtenerCurso(Integer idCurso);
    public CursoEntity registrarCurso(CursoEntity curso);
    public CursoEntity actualizarCurso(CursoEntity curso);
    public void eliminarCurso(Integer idCurso);    
}
