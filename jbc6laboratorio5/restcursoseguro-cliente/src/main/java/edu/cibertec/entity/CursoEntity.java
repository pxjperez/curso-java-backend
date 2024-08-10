package edu.cibertec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcurso")
    private Integer idCurso;
    @Column(name="nomcurso")
    private String nomCurso; 
    @Column(name="fechainicio")
    private String fechaInicio;
    @Column(name="alumnosmin")
    private Integer alumnosMin;
    @Column(name="alumnosact")
    private Integer alumnosAct;
    @Column(name="estado")
    private Integer estado;   
}
