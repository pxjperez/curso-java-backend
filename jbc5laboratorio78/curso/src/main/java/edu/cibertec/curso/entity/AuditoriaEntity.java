package edu.cibertec.curso.entity;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "auditoria")
@Schema(name = "auditoria", description = "Entity de Auditoria") 
public class AuditoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idauditoria")
    private Integer idAuditoria;
    @Column(name="fechahora")
    private Date fechaHora;
    @OneToOne
    @JoinColumn(name="idusuario",updatable = false, nullable = false)
    private UsuarioEntity usuario;
    @Column(name="operacion")
    private String operacion;
    
}
