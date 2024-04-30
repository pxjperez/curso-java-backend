/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.beans;

import org.springframework.stereotype.Component;

/**
 *
 * @author jpere
 */
@Component("documentoExcel")
public class DocumentoExcel implements Documento{

    @Override
    public void imprimir() {
            System.out.println("IMPRIMIENDO UN DOCUMENTO DE EXCEL");        
    }
    
}
