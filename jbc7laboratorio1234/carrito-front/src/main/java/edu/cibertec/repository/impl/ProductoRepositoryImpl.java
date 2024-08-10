package edu.cibertec.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.ProductoResporitory;

@Repository
public class ProductoRepositoryImpl implements ProductoResporitory {

    @Value("${backend.resturl}")
    private String backendRestUrl;

    private RestTemplate template = new RestTemplate();

    @Override
    public List<ProductoDTO> listarProductos() {        
        ProductoDTO[] resultado = template.getForEntity(backendRestUrl+"/productos",ProductoDTO[].class).getBody();
        return Arrays.asList(resultado);
    }

    @Override
    public List<ProductoDTO> listarNuevos() {
        ProductoDTO[] resultado = template.getForEntity(backendRestUrl+"/productos/nuevos",ProductoDTO[].class).getBody();
        return Arrays.asList(resultado);
    }

    @Override
    public List<ProductoDTO> listarNuevosPorCategoria(Integer categoria) {
        ProductoDTO[] resultado = template.getForEntity(backendRestUrl+"/productos/nuevos/categoria/"+categoria,ProductoDTO[].class).getBody();
        return Arrays.asList(resultado);
    }
    
}
