package edu.cibertec.entity;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Table(name="curso")
public class CursoEntity {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Schema(description = "Id del curso", example = "1")
    @Column(name = "idcurso")
    private Integer idCurso;
    @Column(name = "nomcurso")
    private String nombreCruso;
    @Column(name = "fechainicio")
    @Schema(description = "Fecha de inicio en el formato yyyy-MM-dd", example = "2023-10-24")
    private Date fechaInicio;
    @Column(name = "alumnosmin")
    private Integer alumnosMinimo;
    @Column(name = "alumnosact")
    private Integer alumnosActual;
    @Column(name = "estado")
    private Integer estado;
}
