package edu.cibertec.cursoseguro.entity;

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
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private Integer idUsuario;
    @Column(name="usuario")
    private String user;
    @Column(name="clave")
    private String password;
    @Column(name="nombreapellido")
    private String nombreApellido;
    @Column(name="foto")
    private byte[] foto;    
    @Column(name="estado")
    private Integer estado;    
}