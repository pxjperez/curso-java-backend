package edu.cibertec.service;

import java.util.List;

import edu.cibertec.dto.ProductoDto;
import reactor.core.publisher.Flux;

public interface ProductoService {
     public Flux<ProductoDto> listarProductos();    
} 
