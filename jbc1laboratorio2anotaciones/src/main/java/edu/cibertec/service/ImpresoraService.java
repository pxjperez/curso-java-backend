/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.bean.Imprimible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author jpere
 */
public class ImpresoraService {
        
    @Autowired
    @Qualifier("documentoExcel")
    private Imprimible documento;
    @Autowired
    @Qualifier("documentoTexto")
    private Imprimible documentoTexto; //Imprimible documentoTexto = new DocumentoTexto();

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
    public void imprimirDocumentoTexto(){
        System.out.println(documentoTexto.imprimir());
    }
    
}
