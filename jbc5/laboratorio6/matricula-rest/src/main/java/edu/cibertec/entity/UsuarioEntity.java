package edu.cibertec.entity;

import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ch.qos.logback.core.joran.conditional.IfAction;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
@Schema(name = "Usuario",description = "Entity de Usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idUsuario;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "nombreapellido")
    private String nombreApellido;
    @Column(name = "foto")
    @JsonIgnore
    private byte[] foto;
    @Column(name = "estado")
    private int estado;
    @Transient
    @JsonIgnore
    private String fotoBase64;

    public String getFotoBase64() {
       fotoBase64=null;
        if (foto != null) {
            fotoBase64= Base64.getEncoder().encodeToString(foto);
            fotoBase64 = "data:image/png;base64," + fotoBase64;
        }
        return fotoBase64;
    }

}
