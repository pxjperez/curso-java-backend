package edu.cibertec.cursocliente.service;

import java.util.List;

import edu.cibertec.cursocliente.entity.CursoEntity;

public interface CursoService {
    public List<CursoEntity> listarCursos();
    public CursoEntity obtenerCurso(Integer idCurso); 
    public CursoEntity insertarCurso(CursoEntity curso);
    public CursoEntity actualizarCurso(CursoEntity curso);
    public CursoEntity eliminarCurso(Integer idCurso);  
}
