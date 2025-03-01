package edu.cibertec.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.repository.CursoRepository;



@Repository
public class CursoRepositoryImpl implements CursoRepository {

    private RestTemplate restTemplate;
    @Value("${uri.rest.cursos}")
    private String urlServicio;

    public CursoRepositoryImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public List<CursoEntity> listarCursos() {
        return restTemplate.getForObject(urlServicio, List.class);
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return restTemplate.getForObject(urlServicio + "/" + idCurso, CursoEntity.class);
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        return restTemplate.postForObject(urlServicio, curso, CursoEntity.class);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        restTemplate.put(urlServicio + "/" + curso.getIdCurso(), curso);
        return restTemplate.getForObject(urlServicio + "/" + curso.getIdCurso(), CursoEntity.class);
    }

    @Override
    public void eliminarCurso(Integer idCurso) {
        restTemplate.delete(urlServicio + "/" + idCurso);
    }
}
