package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.repository.CategoriaRepository;
import edu.cibertec.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.listarCategorias();
    }
    
}
