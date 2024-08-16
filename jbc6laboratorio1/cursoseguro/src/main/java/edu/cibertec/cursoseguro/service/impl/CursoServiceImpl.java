package edu.cibertec.cursoseguro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.cursoseguro.entity.CursoEntity;
import edu.cibertec.cursoseguro.repository.CursoRepository;
import edu.cibertec.cursoseguro.service.CursoService;

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
    public void insertarCurso(CursoEntity curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void actualizarCurso(CursoEntity curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void eliminarCurso(Integer idCurso) {
        CursoEntity curso = cursoRepository.findById(idCurso).get();
        curso.setEstado(-1);
        cursoRepository.save(curso);
    }
    
}
