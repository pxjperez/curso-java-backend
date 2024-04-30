package edu.cibertec.rest.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import edu.cibertec.rest.entity.PersonaEntity;
import edu.cibertec.rest.repository.PersonaRepository;

@Repository
public class PersonaRepositoryImp implements PersonaRepository {

    private List<PersonaEntity> listaPersonas = new ArrayList<>();

    public PersonaRepositoryImp(){
        PersonaEntity persona1 = new PersonaEntity();
        persona1.setIdPersona(1);
        persona1.setNombre("Juan");
        persona1.setApellido("Pérez");
        persona1.setNumeroDocumento("71583403");
        persona1.setFechaNacimiento(new Date());
        PersonaEntity persona2 = new PersonaEntity();
        persona2.setIdPersona(2);
        persona2.setNombre("Danil");
        persona2.setApellido("Diaz");
        persona2.setNumeroDocumento("12345678");
        persona2.setFechaNacimiento(new Date());
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
    }

     

    @Override
    public List<PersonaEntity> listarPersonas() {
        return this.listaPersonas;
    }

    @Override
    public PersonaEntity obtenerPersona(Integer idPersona) {
        return this.listaPersonas.stream().filter(p->p.getIdPersona().equals(idPersona)).collect(Collectors.toList()).get(0);
    }

    @Override
    public PersonaEntity insertarPersona(PersonaEntity persona) {
        Integer idPersona = listaPersonas.size()+1;
        persona.setIdPersona(idPersona);
        listaPersonas.add(persona);
        PersonaEntity resultado = null;
        if(listaPersonas.size()==idPersona){
            resultado=persona;
        }
        return resultado;
    }

    @Override
    public PersonaEntity actualizarPersona(PersonaEntity persona) {
        return this.listaPersonas.set(persona.getIdPersona()-1,persona);
    }

    @Override
    public void borrarPersona(Integer idPersona) {
        this.listaPersonas.remove(idPersona-1);
    }
    
}
