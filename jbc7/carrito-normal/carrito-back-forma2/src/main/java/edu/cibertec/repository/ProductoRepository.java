package edu.cibertec.repository;

import java.util.List;

import edu.cibertec.dto.ProductoDto;

public interface ProductoRepository {
     public List<ProductoDto> listarProductos();
}
