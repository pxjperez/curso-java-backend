package edu.cibertec.repository.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.cibertec.dto.ProductoDto;
import edu.cibertec.mapper.ProductoMapper;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.repository.dao.ProductoDao;

@Repository
public class ProductoRepositoryImpl  implements ProductoRepository {
    @Autowired
    private ProductoDao productoDao;

    private ProductoMapper mapper = Mappers.getMapper(ProductoMapper.class);

    @Override
    public List<ProductoDto> listarProductos() {
        return mapper.convertirListaEntityToDto(productoDao.findAll());
    }

    
}
