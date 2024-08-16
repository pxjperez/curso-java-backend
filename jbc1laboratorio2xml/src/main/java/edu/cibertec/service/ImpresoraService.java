/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.bean.Imprimible;

/**
 *
 * @author jpere
 */
public class ImpresoraService {
    
    private Imprimible documento;

    public ImpresoraService() {
    }

    public ImpresoraService(Imprimible documento) {
        this.documento = documento;
    }

    public Imprimible getDocumento() {
        return documento;
    }

    public void setDocumento(Imprimible documento) {
        this.documento = documento;
    }
    
    public void imprimirDocumento(){
        System.out.println(documento.imprimir());
    }
    
    
}
