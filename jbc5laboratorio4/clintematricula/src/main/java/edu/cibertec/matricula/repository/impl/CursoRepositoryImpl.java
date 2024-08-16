package edu.cibertec.matricula.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.matricula.entity.CursoEntity;
import edu.cibertec.matricula.repository.CursoRepository;

@Repository
public class CursoRepositoryImpl implements CursoRepository{

    private RestTemplate restTemplate;
    @Value("${uri.rest.cursos}")
    private String urlServidor;

    public CursoRepositoryImpl(){
        restTemplate = new RestTemplate();
    }

    @Override
    public List<CursoEntity> listarCursos() {
        CursoEntity[] cursos = restTemplate.getForObject(urlServidor, CursoEntity[].class);
        return List.of(cursos);
    }

    

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        CursoEntity curso = restTemplate.getForObject(urlServidor + "/" + idCurso, CursoEntity.class);
        return curso;
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        CursoEntity cursoRegistrado = restTemplate.postForObject(urlServidor, curso, CursoEntity.class);
        return cursoRegistrado;
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        restTemplate.put(urlServidor + "/" + curso.getIdCurso(), curso);
        return  restTemplate.getForObject(urlServidor + "/" + curso.getIdCurso(), CursoEntity.class);
    }

    @Override
    public void eliminarCurso(Integer idCurso) {
        restTemplate.delete(urlServidor + "/" + idCurso);
    }
    
}
