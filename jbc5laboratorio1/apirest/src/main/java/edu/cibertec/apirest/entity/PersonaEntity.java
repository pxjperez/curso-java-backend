package edu.cibertec.apirest.entity;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity {
    private Integer codigo;
    private String nombre;
    private String nroDoc;
    private Date fechaNacimiento;
}
