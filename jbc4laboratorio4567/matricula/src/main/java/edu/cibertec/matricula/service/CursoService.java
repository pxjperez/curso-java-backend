package edu.cibertec.matricula.service;

import java.util.List;

import edu.cibertec.matricula.entity.CursoEntity;

public interface CursoService {    
    public List<CursoEntity> listarCursos();
    public CursoEntity obtenerCurso(Integer idCurso);
    public CursoEntity guardarCurso(CursoEntity curso);
    public CursoEntity actualizarCurso(CursoEntity curso);
    public CursoEntity eliminarCurso(Integer idCurso);
}
