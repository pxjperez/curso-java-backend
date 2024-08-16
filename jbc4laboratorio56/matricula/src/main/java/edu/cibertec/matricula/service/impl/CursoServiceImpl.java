package edu.cibertec.matricula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.matricula.entity.CursoEntity;
import edu.cibertec.matricula.repository.CursoRepository;
import edu.cibertec.matricula.service.CursoService;

@Service
public class CursoServiceImpl  implements CursoService{

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public CursoEntity obtenerCurso(int idCurso) {
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
    public CursoEntity eliminarCruso(int idCurso) {        
        CursoEntity curso = cursoRepository.findById(idCurso).get();
        curso.setEstado(-1);
        cursoRepository.save(curso);
        return curso;
    }
    
}
 