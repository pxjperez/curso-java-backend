package edu.cibertec.apirest.repository;

import java.util.List;

import edu.cibertec.apirest.entity.PersonaEntity;

public interface PersonaRepository {
    public List<PersonaEntity> listarPersonas();
    public PersonaEntity obtenerPersona(Integer codigo);
    public PersonaEntity registrarPersona(PersonaEntity persona);
    public PersonaEntity actualizarPersona(PersonaEntity persona);
    public void eliminarPersona(Integer codigo);
}
