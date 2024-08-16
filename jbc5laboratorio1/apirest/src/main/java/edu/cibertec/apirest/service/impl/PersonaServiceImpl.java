package edu.cibertec.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.apirest.entity.PersonaEntity;
import edu.cibertec.apirest.repository.PersonaRepository;
import edu.cibertec.apirest.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaEntity> listarPersonas() {        
        return personaRepository.listarPersonas();
    }

    @Override
    public PersonaEntity obtenerPersona(Integer codigo) {
        return personaRepository.obtenerPersona(codigo);
    }

    @Override
    public PersonaEntity registrarPersona(PersonaEntity persona) {
        return personaRepository.registrarPersona(persona);
    }

    @Override
    public PersonaEntity actualizarPersona(PersonaEntity persona) {
        return personaRepository.actualizarPersona(persona);
    }

    @Override
    public void eliminarPersona(Integer codigo) {
        personaRepository.eliminarPersona(codigo);
    }
    
}
