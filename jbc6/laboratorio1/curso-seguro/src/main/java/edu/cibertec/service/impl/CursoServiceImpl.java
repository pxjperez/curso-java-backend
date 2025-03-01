package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.repository.CursoRepository;
import edu.cibertec.service.CursoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Lombok genera un constructor con los atributos marcados como final // Tener cuidado con los atributos que no tinen instancias
public class CursoServiceImpl implements CursoService {
    
    private final CursoRepository cursoRepository;


    @Override
    public List<CursoEntity> listarCursos() {
        return cursoRepository.findByEstado(1);
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return cursoRepository.findById(idCurso).orElse(null);
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
    public CursoEntity eliminarCurso(Integer idCurso) {
        CursoEntity curso = cursoRepository.findById(idCurso).orElse(null);
        if (curso != null) {
            curso.setEstado(0);
            cursoRepository.save(curso);
        }
        return curso;
    }
    
}
