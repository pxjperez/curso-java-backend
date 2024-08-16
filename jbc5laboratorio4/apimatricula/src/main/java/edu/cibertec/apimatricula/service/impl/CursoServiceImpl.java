package edu.cibertec.apimatricula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.apimatricula.entity.CursoEntity;
import edu.cibertec.apimatricula.service.CursoService;
import edu.cibertec.apimatricula.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return cursoRepository.findById(idCurso).get();
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void eliminarCurso(Integer idCurso) {
        CursoEntity cursoEntity=cursoRepository.findById(idCurso).get();
        cursoEntity.setEstado(-1);
        cursoRepository.save(cursoEntity);
    }
    
}
