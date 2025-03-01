package edu.cibertec.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.ProductoDto;
import edu.cibertec.mapper.ProductoMapper;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;

@Service
public class PorductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    private ProductoMapper mapper = Mappers.getMapper(ProductoMapper.class);

    @Override
    public List<ProductoDto> listarProductos() {
        return mapper.convertirListaEntityToDto(productoRepository.findAll());
    }
    
}
