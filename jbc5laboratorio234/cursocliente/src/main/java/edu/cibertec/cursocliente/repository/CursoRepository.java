package edu.cibertec.cursocliente.repository;

import java.util.List;

import edu.cibertec.cursocliente.entity.CursoEntity;

public interface CursoRepository {
    public List<CursoEntity> listarCursos();
    public CursoEntity obtenerCurso(Integer idCurso); 
    public CursoEntity insertarCurso(CursoEntity curso);
    public CursoEntity actualizarCurso(CursoEntity curso);
    public CursoEntity eliminarCurso(Integer idCurso);    
}
