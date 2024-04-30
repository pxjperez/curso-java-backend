/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.bean;

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
public class Usuario {
    private Integer idUsuario;
    @Size(min=3, max=20, message="El user debe de tener como minimo 3 caracteres y como maximo 20")
    @NotNull(message="El user del usuario no puede ser nulo")
    private String user;
    @NotNull(message="El password del usuario no puede ser nulo")
    @Size(min=1,message = "El password del usuario no puede estar en blanco")
    private String password;
    @NotNull(message="El nombre Completo del usuario no puede ser nulo")
    @Size(min=1,message = "El nombre Completo del usuario no puede estar en blanco")
    private String nombreCompleto;
}
