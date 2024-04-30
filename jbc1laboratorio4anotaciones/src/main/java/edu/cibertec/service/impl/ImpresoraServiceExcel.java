/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service.impl;

import edu.cibertec.respository.Imprimible;
import edu.cibertec.service.ImpresoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
@DependsOn(value = {"documentoExcel"})
public class ImpresoraServiceExcel implements ImpresoraService {

    @Autowired
    @Qualifier("documentoExcel")
    private Imprimible documento;

    @Override
    public void mostraTipo() {
        System.out.println(documento.imprimir());
    }

}
