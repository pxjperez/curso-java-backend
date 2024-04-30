/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jpere
 */
@Entity
@Table(name = "matricula")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmatricula")//idMatricula => id_matricula
    private Integer idMatricula;
    @Column(name = "fechamat")
    private Date fechaMat;
    @OneToOne
    @JoinColumn(name = "idusuario", updatable = false, nullable = false)
    private UsuarioEntity usuario;
    @OneToOne
    @JoinColumn(name = "idcurso", updatable = false, nullable = false)
    private CursoEntity curso;
    @Column(name = "estado")
    private Integer estado; 
}
