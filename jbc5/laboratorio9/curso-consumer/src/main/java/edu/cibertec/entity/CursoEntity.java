package edu.cibertec.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CursoEntity {
    private Integer idCurso;
    private String nombreCurso;
    private Date fechaInicio;
    private Integer alumnosMinimo;
    private Integer alumnosActual;
    private Integer estado;
}
