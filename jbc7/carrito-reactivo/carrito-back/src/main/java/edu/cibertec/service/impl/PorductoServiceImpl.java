package edu.cibertec.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.ProductoDto;
import edu.cibertec.mapper.CategoriaMapper;
import edu.cibertec.mapper.ProductoMapper;
import edu.cibertec.repository.CategoriaRepository;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;
import reactor.core.publisher.Flux;

@Service
public class PorductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    private ProductoMapper mapperProducto = Mappers.getMapper(ProductoMapper.class);
    private CategoriaMapper mapperCategoria = Mappers.getMapper(CategoriaMapper.class);

    @Override
    public Flux<ProductoDto> listarProductos() {
        return productoRepository.findAll()
            .flatMap(producto -> categoriaRepository.findById(producto.getIdCategoria())
                .map(categoria -> {
                    ProductoDto productoDto = mapperProducto.convertirEntityToDto(producto);
                    productoDto.setCategoria(mapperCategoria.convertirEntityToDto(categoria));
                    return productoDto;
                })
            );
    }
    
}
