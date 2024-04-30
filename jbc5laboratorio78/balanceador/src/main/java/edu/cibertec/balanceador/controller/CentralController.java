package edu.cibertec.balanceador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CentralController {
    
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/apim/cursos")
    public String listarCursos() {
        return restTemplate.getForObject("htttp://MATRICULAAPP/api/v1/cursos", String.class);
    }
    
}
