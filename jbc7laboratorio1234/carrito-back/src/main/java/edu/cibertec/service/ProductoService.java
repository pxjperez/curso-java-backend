package edu.cibertec.service;

import java.util.List;

import edu.cibertec.dto.ProductoDTO;

public interface ProductoService {
    public List<ProductoDTO> listarProductos();
    public List<ProductoDTO> listarNuevos(Integer estado);
    public List<ProductoDTO> listarNuevosPorCategoria(Integer estado, Integer categoria);
}
