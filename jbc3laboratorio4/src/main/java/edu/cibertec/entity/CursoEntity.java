/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jpere
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
@NamedQueries(
        @NamedQuery(
                name = "CursoEntity.abiertoIncompleto",
                query = "SELECT c FROM CursoEntity c WHERE c.alumnosMinimo>c.alumnosActual AND c.estado=1"
        )
)
@NamedNativeQueries(
        @NamedNativeQuery(
                name = "CursoEntity.abiertoIncompletoNativo",
                query = "SELECT * FROM curso WHERE alumnosmin>alumnosact AND estado=1",resultClass = CursoEntity.class
        )
)
public class CursoEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idCurso;
    @Column(name = "nomcurso")
    private String nombreCurso;
    @Column(name = "fechainicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "alumnosmin")
    private Integer alumnosMinimo;
    @Column(name = "alumnosact")
    private Integer alumnosActual;
    @Column(name = "estado")
    private Integer estado; 
    @Transient
    private String estadoString;
    
    public String getEstadoString(){
        String resultado ="";
        switch (this.estado) {
            case 0:
                resultado="CREADO";
                break;
            case 1:
                resultado="EN PROCESO DE VENTA";
                break;
            case 2:
                resultado="COMPLETO";
                break;
            default:
                resultado="-ESTADO-";
                break;
        }
        return resultado;
    }
}
