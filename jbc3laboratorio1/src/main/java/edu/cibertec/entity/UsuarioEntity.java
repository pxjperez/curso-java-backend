/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.entity;

import java.util.Base64;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Table(name = "usuario")
public class UsuarioEntity {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;
    @Size(min=3, max=30, message = "El tamaño tiene que estar entre 3 y 30")
    @Column(name = "usuario")
    private String user;
    @NotBlank(message = "El password no puede estar vacio")
    @NotNull(message = "El password no puede estar vacio")
    @Size(min=1, max=30, message = "El password no puede estar vacio")
    @Column(name = "clave")
    private String password;
    @NotBlank(message = "El nombre no puede estar vacio")
    @NotNull(message = "El nombre no puede estar vacio")
    @Size(min=1, max=30, message = "El nombre no puede estar vacio")
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
            return "";
        }
        
    }
}
