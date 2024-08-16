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
    private String nomembreCurso;
    private Date fechaInicio; 
    private Integer alumnosMin; 
    private Integer alumnosAct; 
    private Integer estado; 
}