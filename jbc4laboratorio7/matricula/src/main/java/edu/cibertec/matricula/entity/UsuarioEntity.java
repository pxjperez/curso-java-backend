package edu.cibertec.matricula.entity;

import java.util.Base64;

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

//Mapeando las tablas
@Entity
@Table(name = "usuario")
//Usando Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idUsuario;
    @Column(name = "usuario")
    private String user;
    @Column(name = "clave")
    private String password;
    @Column(name = "nombreapellido")
    private String nombreCompleto;
    @Column(name = "foto")
    private byte[] foto;
    @Transient
    private String fotoBase64;
    public String getFotoBase64(){
        if(this.foto!=null){
            return Base64.getEncoder().encodeToString(this.foto);
        }else{
            return null;
        }
    }
}
