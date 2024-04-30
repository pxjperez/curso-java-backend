/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.bean;

import java.io.Serializable;
import java.util.Date;
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
public class Persona implements Serializable{
    private String nombre;
    private String apellido;
    private String documento;
    private String direccion;
    private Date nacimiento;
}
