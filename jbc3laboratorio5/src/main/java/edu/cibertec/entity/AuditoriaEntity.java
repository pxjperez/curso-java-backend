/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jpere
 */
@Entity
@Table(name="auditoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "idauditoria")
   private Integer idAuditoria;
   @Column(name = "fechahora", columnDefinition = "DATATIME")
   @Temporal(TemporalType.TIMESTAMP)
   private Date fechaHora;
   @OneToOne
   @JoinColumn(name = "idusuario", updatable = false, nullable = false)
   private UsuarioEntity usuario;
   @Column(name = "operacion")
   private String operacion;

    public AuditoriaEntity(Date fechaHora, UsuarioEntity usuario, String operacion) {
        this.fechaHora = fechaHora;
        this.usuario = usuario;
        this.operacion = operacion;
    }
   
}
