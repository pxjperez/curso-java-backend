package edu.cibertec.apirest.service;

import java.util.List;

import edu.cibertec.apirest.entity.PersonaEntity;

public interface PersonaService {
    public List<PersonaEntity> listarPersonas();
    public PersonaEntity obtenerPersona(Integer codigo);
    public PersonaEntity registrarPersona(PersonaEntity persona);
    public PersonaEntity actualizarPersona(PersonaEntity persona);
    public void eliminarPersona(Integer codigo);
}
