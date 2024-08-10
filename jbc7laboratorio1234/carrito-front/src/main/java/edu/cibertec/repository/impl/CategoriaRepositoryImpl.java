package edu.cibertec.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.CategoriaRepository;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository{

    @Value("${backend.resturl}")
    private String backendRestUrl;

    private RestTemplate template = new RestTemplate();

    @Override
    public List<CategoriaDTO> listarCategorias() {
        CategoriaDTO[] resultado = template.getForEntity(backendRestUrl+"/categorias",CategoriaDTO[].class).getBody();
        return Arrays.asList(resultado);
    }
    
}
