package edu.cibertec.apirest.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import edu.cibertec.apirest.entity.PersonaEntity;
import edu.cibertec.apirest.repository.PersonaRepository;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {

    private List<PersonaEntity> bd=new ArrayList();
    
    public PersonaRepositoryImpl(){
        this.bd.add(new PersonaEntity(1, "Juan Perez", "71583403", new Date()));
        this.bd.add(new PersonaEntity(2, "Daniel Diaz", "12345678", new Date()));
        this.bd.add(new PersonaEntity(3, "Javier Mendoza", "87654321", new Date()));
    }
    @Override
    public List<PersonaEntity> listarPersonas() {
        return this.bd;
    }

    @Override
    public PersonaEntity obtenerPersona(Integer codigo) {
        return this.bd.stream().filter(p->p.getCodigo().equals(codigo)).collect(Collectors.toList()).get(0);
    }

    @Override
    public PersonaEntity registrarPersona(PersonaEntity persona) {
        this.bd.add(persona);
        return persona;
    }

    @Override
    public PersonaEntity actualizarPersona(PersonaEntity persona) {
        this.bd=this.bd.stream().map(p->{
            if(p.getCodigo().equals(persona.getCodigo())){
                return persona;
            }
            return p;
        }).collect(Collectors.toList());
        return persona; 
    }

    @Override
    public void eliminarPersona(Integer codigo) {
        this.bd.removeIf(p->p.getCodigo().equals(codigo));
    }
    
}
