/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.respository.impl;

import edu.cibertec.respository.Imprimible;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public class DocumentoExcel implements Imprimible{

    public void  iniciar(){
        System.out.println("Iniciando la construcion del bean DocumentoExcel");
    }
    public void destruir(){
        System.out.println("Destruyendo el bean DocumentoExcel");
    }
    @Override
    public String imprimir() {
        return "Imprimiendo desde un archivo Excel";
    }
    
}
