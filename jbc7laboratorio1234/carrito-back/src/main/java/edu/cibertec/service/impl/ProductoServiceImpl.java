package edu.cibertec.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.mapper.ProductoEntityMapper;
import edu.cibertec.repository.CategoriaRepository;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    private ProductoEntityMapper mapper = Mappers.getMapper(ProductoEntityMapper.class);

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return mapper.convertirListEntityADTO(productoRepository.findAll());
    }

    @Override
    public List<ProductoDTO> listarNuevos(Integer estado) {
        return mapper.convertirListEntityADTO(productoRepository.findByNueProducto(estado));
    }

    @Override
    public List<ProductoDTO> listarNuevosPorCategoria(Integer estado, Integer categoria) {
        return mapper.convertirListEntityADTO(productoRepository.findByNueProductoAndCategoria(estado, categoria));
    }
    
}
