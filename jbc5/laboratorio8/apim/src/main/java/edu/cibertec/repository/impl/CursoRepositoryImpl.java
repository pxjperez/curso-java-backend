package edu.cibertec.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.repository.CursoRepository;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

    @Value("${ulr.api}")
    private String urlApi;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CursoEntity> listarCursos() {        
        return restTemplate.getForObject(urlApi, List.class);
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return restTemplate.getForObject(urlApi + "/" + idCurso, CursoEntity.class);
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        return restTemplate.postForObject(urlApi, curso, CursoEntity.class);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        restTemplate.put(urlApi + "/" + curso.getIdCurso(), curso);
        return obtenerCurso(curso.getIdCurso());
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {        
        restTemplate.delete(urlApi + "/" + idCurso);
        return obtenerCurso(idCurso);
    }
    
}
