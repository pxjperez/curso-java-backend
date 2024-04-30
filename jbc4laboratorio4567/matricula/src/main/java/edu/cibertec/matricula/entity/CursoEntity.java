package edu.cibertec.matricula.entity;

import java.sql.Date;

import org.hibernate.annotations.Parent;
import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idCurso;
    @NotNull(message = "{curso.nomCurso.nulo}")
    @NotBlank(message = "{curso.nomCurso.nulo}")
    @Size(min=3, max=40)//El mensaje se esta configurando por defecto en el archivo properties 
    @Column(name = "nomcurso")  
    private String nomCurso;
    @NotNull(message = "{curso.fechaInicio.nulo}")
    //@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",message = "Ingrese una fecha validad")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //@Temporal(TemporalType.DATE)
    @Column(name = "fechainicio")
    private Date fechaInicio;
    @NotNull(message = "{curso.alumnosMin.nulo}")
    @Min(value = 1, message = "El la cantidad de almunos no puede estar vacia")
    @Column(name = "alumnosmin")
    private Integer alumnosMin;
    @Column(name = "alumnosact")
    private Integer alumnosAct;
    @NotNull(message = "{curso.estado.nulo}")
    @Column(name = "estado")
    private Integer estado; 
}
