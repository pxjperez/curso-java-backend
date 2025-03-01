package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.dto.ProductoDto;
import edu.cibertec.service.ProductoService;

@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDto> listarProductos() {
        return productoService.listarProductos();
    }
}
