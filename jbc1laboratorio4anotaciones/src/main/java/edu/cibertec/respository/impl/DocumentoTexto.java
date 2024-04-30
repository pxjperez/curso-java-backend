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
public class DocumentoTexto implements Imprimible {

    public void iniciar() {
        System.out.println("Iniciando la construcion del bean DocumentoTexto");
    }

    public void destruir() {
        System.out.println("Destruyendo el bean DocumentoTexto");
    }

    @Override
    public String imprimir() {
        return "Imprimiendo desde un archivo Texto";
    }

}
