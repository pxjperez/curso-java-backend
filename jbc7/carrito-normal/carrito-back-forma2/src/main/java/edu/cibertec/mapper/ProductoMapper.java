package edu.cibertec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.ProductoDto;
import edu.cibertec.entity.ProductoEntity;

@Mapper
public interface ProductoMapper {
    public ProductoEntity convertirDtoToEntity(ProductoDto producto);
    public ProductoDto convertirEntityToDto(ProductoEntity producto);
    public List<ProductoEntity> convertirListaDtoToEntity(List<ProductoDto> listaProductos);
    public List<ProductoDto> convertirListaEntityToDto(List<ProductoEntity> listaProductos);
}
