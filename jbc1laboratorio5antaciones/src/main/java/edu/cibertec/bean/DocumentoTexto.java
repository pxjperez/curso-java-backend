/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.bean;

import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public class DocumentoTexto implements Imprimible {
    @Override
    public String imprimir() {
            return "Imprimiendo desde un archivo de texto";
    }
}
