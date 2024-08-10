package edu.cibertec.repository;

import java.util.List;

import edu.cibertec.dto.ProductoDTO;

public interface ProductoResporitory {
    public List<ProductoDTO> listarProductos();
    public List<ProductoDTO> listarNuevos();
    public List<ProductoDTO> listarNuevosPorCategoria(Integer categoria);
}
