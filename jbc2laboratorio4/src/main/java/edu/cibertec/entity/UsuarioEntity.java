/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.entity;

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
public class UsuarioEntity {    
    private Integer idUsuario;
    @Size(min=3, max=30, message = "El tamaño tiene que estar entre 3 y 30")
    private String user;
    @NotBlank(message = "El password no puede estar vacio")
    @NotNull(message = "El password no puede estar vacio")
    @Size(min=1, max=30, message = "El password no puede estar vacio")
    private String password;
    @NotBlank(message = "El nombre no puede estar vacio")
    @NotNull(message = "El nombre no puede estar vacio")
    @Size(min=1, max=30, message = "El nombre no puede estar vacio")
    private String nombreCompleto;
    private byte[] foto;
}
