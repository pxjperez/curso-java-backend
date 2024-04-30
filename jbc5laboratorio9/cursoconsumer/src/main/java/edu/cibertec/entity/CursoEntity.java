package edu.cibertec.entity;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoEntity {
    private Integer idCurso;
    private String nombreCruso;
    private Date fechaInicio;
    private Integer alumnosMinimo;
    private Integer alumnosActual;
    private Integer estado;
}
