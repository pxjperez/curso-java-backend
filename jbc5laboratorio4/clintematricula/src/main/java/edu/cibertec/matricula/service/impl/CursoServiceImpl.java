package edu.cibertec.matricula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.matricula.entity.CursoEntity;
import edu.cibertec.matricula.repository.CursoRepository;
import edu.cibertec.matricula.service.CursoService;

@Service
public class CursoServiceImpl implements  CursoService {

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
    public CursoEntity registrarCurso(CursoEntity curso) {
        return cursoRepository.registrarCurso(curso);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        return cursoRepository.actualizarCurso(curso);
    }

    @Override
    public void eliminarCurso(Integer idCurso) {
        cursoRepository.eliminarCurso(idCurso);
    }
    
}
