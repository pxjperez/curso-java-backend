/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.bean.DocumentoExcel;
import edu.cibertec.bean.Imprimible;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
@Lazy(value = true)
public class ImpresoraService {
    
   
//    @Autowired
//    @Qualifier("documentoExcel")
    private Imprimible documento;
    @Autowired
    @Qualifier("documentoTexto")
    private Imprimible documentoTexto; 

    public ImpresoraService() {
    }

    @Autowired
    public ImpresoraService(@Qualifier("documentoExcel") Imprimible documento) {
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
    
    @PostConstruct
    public void iniciar(){
        System.out.println("INICIANDO IMPRESORA");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("DESTRUIR IMPRESORA");
    }
}
