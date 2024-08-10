package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.service.CategoriaService;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public List<CategoriaDTO>listarCategorias(){
        return categoriaService.listarCategorias();
    }   
}
