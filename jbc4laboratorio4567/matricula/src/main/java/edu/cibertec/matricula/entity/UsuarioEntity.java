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

@Entity
@Table(name="usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name = "idusuario")
   private Integer idUsuario;
   @Column(name = "usuario")
   private String usuario;
   @Column(name = "clave")
   private String clave;
   @Column(name = "nombreapellido")
   private String nombreApellido;
   @Column(name = "foto")
   private byte[] foto;
   @Transient
   private String foto64;
   public String getFoto64(){
        if (this.foto != null) {
            return Base64.getEncoder().encodeToString(this.foto);
        }else{
            return null;
        }
    }
}
