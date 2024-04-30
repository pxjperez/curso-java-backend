package edu.cibertec.cursocliente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.cursocliente.entity.CursoEntity;
import edu.cibertec.cursocliente.repository.CursoRepository;
import edu.cibertec.cursocliente.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> listarCursos() {
        return cursoRepository.listarCursos();
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return cursoRepository.obtenerCurso(idCurso);
    }

    @Override
    public CursoEntity insertarCurso(CursoEntity curso) {
        return cursoRepository.insertarCurso(curso);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        return cursoRepository.actualizarCurso(curso);
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {
        return cursoRepository.eliminarCurso(idCurso);
    }
    
}
