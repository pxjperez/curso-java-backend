package edu.cibertec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.entity.ProductoEntity;

@Mapper
public interface ProductoEntityMapper {
    public ProductoEntity convertirDTOAEntity(ProductoDTO producto);
    public ProductoDTO convertirEntityADTO(ProductoEntity producto);
    public List<ProductoEntity> convertirListDTOAEntity(List<ProductoDTO>LISTA);
    public List<ProductoDTO> convertirListEntityADTO(List<ProductoEntity>LISTA);
}
