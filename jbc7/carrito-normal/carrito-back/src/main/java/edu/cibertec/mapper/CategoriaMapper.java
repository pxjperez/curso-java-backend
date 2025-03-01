package edu.cibertec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.CategoriaDto;
import edu.cibertec.entity.CategoriaEntity;

@Mapper
public interface CategoriaMapper {
    public CategoriaEntity convertirDtoToEntity(CategoriaDto producto);
    public CategoriaDto convertirEntityToDto(CategoriaEntity producto);
    public List<CategoriaEntity> convertirListaDtoToEntity(List<CategoriaDto> listaProductos);
    public List<CategoriaDto> convertirListaEntityToDto(List<CategoriaEntity> listaProductos);
}
