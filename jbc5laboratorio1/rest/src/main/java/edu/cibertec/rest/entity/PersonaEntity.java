package edu.cibertec.rest.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity{
    private Integer idPersona;
    private String nombre;
    private String apellido;    
    private String numeroDocumento;
    private Date fechaNacimiento;
}
