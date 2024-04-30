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
       return cursoRepository.findAll();
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
       return cursoRepository.findById(idCurso).get();
    }

    @Override
    public void insertarCurso(CursoEntity cursoEntity) {
        cursoRepository.save(cursoEntity);
    }

    @Override
    public void actualizarCurso(CursoEntity cursoEntity) {
        cursoRepository.save(cursoEntity);    
    }

    @Override
    public void eliminarCurso(Integer idCurso) {
      CursoEntity cursoEntity= cursoRepository.findById(idCurso).get();
      cursoEntity.setEstado(0);
      cursoRepository.save(cursoEntity);
    }
    
}
