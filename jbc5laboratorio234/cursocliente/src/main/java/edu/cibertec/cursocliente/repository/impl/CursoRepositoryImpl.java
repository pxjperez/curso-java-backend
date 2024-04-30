package edu.cibertec.cursocliente.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.cursocliente.entity.CursoEntity;
import edu.cibertec.cursocliente.repository.CursoRepository;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

    private RestTemplate restTemplate;
    @Value("${uri.rest.curso}")
    private String urlServidor;

    public CursoRepositoryImpl(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<CursoEntity> listarCursos() {
        List<CursoEntity> repuesta = null;
        CursoEntity[] lista = restTemplate.getForObject(urlServidor, CursoEntity[].class);
        repuesta= Arrays.asList(lista);
        return repuesta;
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        CursoEntity repuesta = null;
        repuesta = restTemplate.getForObject(urlServidor+"/"+idCurso, CursoEntity.class);
        return repuesta;
    }

    @Override
    public CursoEntity insertarCurso(CursoEntity curso) {
        ResponseEntity<CursoEntity> repuesta = null;
        repuesta = restTemplate.postForEntity(urlServidor,curso, CursoEntity.class);
        return repuesta.getBody();
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        restTemplate.put(urlServidor+"/"+curso.getIdCurso(),curso);
        CursoEntity repuesta = restTemplate.getForObject(urlServidor+"/"+curso.getIdCurso(), CursoEntity.class);
        return repuesta;
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {
        restTemplate.delete(urlServidor+"/"+idCurso);
        CursoEntity repuesta = restTemplate.getForObject(urlServidor+"/"+idCurso, CursoEntity.class);
        return repuesta;
    }
    
}
