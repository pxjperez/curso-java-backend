package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.ProductoResporitory;
import edu.cibertec.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoResporitory productoResporitory;

    @Override
    public List<ProductoDTO> listarProductos() {
        return productoResporitory.listarProductos();
    }

    @Override
    public List<ProductoDTO> listarNuevos() {
        return productoResporitory.listarNuevos();
    }

    @Override
    public List<ProductoDTO> listarNuevosPorCategoria(Integer categoria) {
        return productoResporitory.listarNuevosPorCategoria(categoria);
    }
    
}
