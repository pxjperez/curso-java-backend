package edu.cibertec.curso.entity;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "usuario")
@Schema(name = "usuario" , description = "Entity de Usuario") 
public class UsuarioEntity extends RepresentationModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private Integer idUsuario;
    @Column(name="usuario")
    private String usuario;
    @Column(name="clave")
    private String clave;
    @Column(name="nombreapellido")
    private String nombreApellido;
    @Column(name="foto")
    private byte[] foto;

}
