package edu.cibertec.rest.service;

import java.util.List;

import edu.cibertec.rest.entity.PersonaEntity;

public interface PersonaService {
    public List<PersonaEntity> listarPersonas();
    public PersonaEntity obtenerPersona(Integer idPersona);
    public PersonaEntity insertarPersona(PersonaEntity persona);
    public PersonaEntity actualizarPersona(PersonaEntity persona);
    public void borrarPersona(Integer idPersona);
}
