/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.repository.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
public class ImpresoraServiceTexto implements ImpresoraService {

    @Autowired
    @Qualifier("documentoTexto")
    private Documento documento;

    @Override
    public void imprimir() {
        documento.imprimir();
    }

}
