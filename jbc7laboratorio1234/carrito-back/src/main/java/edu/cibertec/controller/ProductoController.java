package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.service.ProductoService;

@RestController
@RequestMapping("api/v1/productos")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @GetMapping
    public List<ProductoDTO>listarProductos(){
        return productoService.listarProductos();
    }    

    @GetMapping("/nuevos")
    public List<ProductoDTO>listarProductosNuevos(){
        return productoService.listarNuevos(1);
    }    
    @GetMapping("/nuevos/categoria/{idCategoria}")
    public List<ProductoDTO>listarProductosNuevosPorCategoria(@PathVariable("idCategoria") Integer idCategoria){
        return productoService.listarNuevosPorCategoria(1,idCategoria);
    }   
    
}
