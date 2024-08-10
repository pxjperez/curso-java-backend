package edu.cibertec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.entity.CategoriaEntity;

@Mapper
public interface CategoriaEntityMapper {
    public CategoriaEntity convertirDTOAEntity(CategoriaDTO categoria);
    public CategoriaDTO convertirEntityADTO(CategoriaEntity categoria);
    public List<CategoriaEntity> convertirListDTOAEntity(List<CategoriaDTO>LISTA);
    public List<CategoriaDTO> convertirListEntityADTO(List<CategoriaEntity>LISTA);
}
