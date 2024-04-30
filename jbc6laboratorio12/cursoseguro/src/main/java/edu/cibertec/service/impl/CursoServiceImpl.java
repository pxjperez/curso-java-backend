package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.repository.CursoRepository;
import edu.cibertec.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

       
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> listarCursos() {
        return  cursoRepository.findAll();
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return  cursoRepository.findById(idCurso).get();
    }

    @Override
    public CursoEntity insertarCurso(CursoEntity curso) {
        return  cursoRepository.save(curso);
    }

    @Override
    public CursoEntity actualizCurso(CursoEntity curso) {
        return  cursoRepository.save(curso);
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {
        CursoEntity curso = cursoRepository.findById(idCurso).get();
        curso.setEstado(0);
        return  cursoRepository.save(curso);    
    }

    
    
}
