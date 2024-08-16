package edu.cibertec.apim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.apim.entity.CursoEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/apim/cursos")
public class ApimController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping    
    public String listarCursos(){
        return restTemplate.getForObject("http://MATRICULAAPP/api/v1/cursos", String.class);
    }

    @GetMapping("{idCurso}")    
    public String obtenerCurso(@PathVariable("idCurso")Integer idCurso){
        return restTemplate.getForObject("http://MATRICULAAPP/api/v1/cursos/"+idCurso, String.class);
    }

    @PostMapping
    public CursoEntity registrarCurso(@RequestBody CursoEntity curso) {
        CursoEntity cursoRegistrado = restTemplate.postForObject("http://MATRICULAAPP/api/v1/cursos", curso, CursoEntity.class);
        return cursoRegistrado;
    }
    
}
