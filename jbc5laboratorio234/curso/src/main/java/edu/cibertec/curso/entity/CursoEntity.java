package edu.cibertec.curso.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idCurso;
    @Column(name = "nomcurso")
    private String nombreCurso;
    @Column(name = "fechainicio")
    private Date fechaInicio;
    @Column(name = "alumnosmin")
    private Integer alumnosMinimo;
    @Column(name = "alumnosact")
    private Integer alumnosActual;
    @Column(name = "estado")
    private Integer estado;
}
