package edu.cibertec.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.rest.entity.PersonaEntity;
import edu.cibertec.rest.repository.PersonaRepository;
import edu.cibertec.rest.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaEntity> listarPersonas() {
        return personaRepository.listarPersonas();
    }

    @Override
    public PersonaEntity obtenerPersona(Integer idPersona) {
        return personaRepository.obtenerPersona(idPersona);
    }

    @Override
    public PersonaEntity insertarPersona(PersonaEntity persona) {
        return personaRepository.insertarPersona(persona);
    }

    @Override
    public PersonaEntity actualizarPersona(PersonaEntity persona) {
        return personaRepository.actualizarPersona(persona);
    }

    @Override
    public void borrarPersona(Integer idPersona) {
       personaRepository.borrarPersona(idPersona);
    }
    
}
