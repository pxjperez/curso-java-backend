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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jpere
 */
@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    @Id
    //PARA MYSQL
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    //PARA VARIAS BD
//    (1) @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//    (2) @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "idusuario") //idUsuario // id_usuario
    private Integer idUsuario;
    @Column(name ="usuario",nullable = false)
    @Size(min=3, max=20, message="El user debe de tener como minimo 3 caracteres y como maximo 20")
    @NotNull(message="El user del usuario no puede ser nulo")
    private String user;
    @Column(name ="clave",nullable = false)
    @NotNull(message="El password del usuario no puede ser nulo")
    @Size(min=1,message = "El password del usuario no puede estar en blanco")
    private String clave;
    @Column(name ="nombreapellido",nullable = false)
    @NotNull(message="El nombre Completo del usuario no puede ser nulo")
    @Size(min=1,message = "El nombre Completo del usuario no puede estar en blanco")
    private String nombreApellido;
    private byte[]  foto;
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
