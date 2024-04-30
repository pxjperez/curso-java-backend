/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.repository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */

@Repository
public class DocumentoTexto implements Documento{

    @Override
    public void imprimir() {
        System.out.println("IMPRIMIENDO UN DOCUMENTO DE TEXTO");   
    }
    
}
