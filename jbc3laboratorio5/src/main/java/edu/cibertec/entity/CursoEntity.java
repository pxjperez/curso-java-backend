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
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jpere
 */
@Entity
@Table(name="curso")
//@NamedQuery(name="CursoEntity.abiertoIncompleto",query="SELECT c FROM CursoEntity c WHERE c.alumnosMin>c.alumnosAct and c.estado=1")
@NamedNativeQuery(name="CursoEntity.abiertoIncompleto",query="SELECT * FROM curso WHERE alumnosmin>alumnosact and estado=1",resultClass = CursoEntity.class )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idCurso;
    @Column(name = "nomcurso")
    private String nomCurso;
    @Column(name = "fechainicio")
    private Date fechaIncicio;
    @Column(name = "alumnosmin")
    private Integer alumnosMin;
    @Column(name = "alumnosact")
    private Integer alumnosAct;
    @Column(name = "estado")
    private Integer estado;
}
