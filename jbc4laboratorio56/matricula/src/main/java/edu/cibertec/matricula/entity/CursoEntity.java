package edu.cibertec.matricula.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idCurso;

    @Column(name = "nomcurso")
    @Size(min=3, max=40,message = "{curso.nomCurso.nulo}")
    private String nomCurso;

    @Column(name = "fechainicio")
    @NotNull(message = "La fecha no puede estar vacia")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "alumnosmin")
    @Min(value=1, message = "El campo alumnos minimo no puede estar vacio")
    private Integer alumnosMin;

    @Column(name = "alumnosact")
    @Min(value=1) //message = "El campo alumnos actualizado no puede estar vacio"
    private Integer alumnosAct;

    @Column(name = "estado")
    private Integer estado;
}
