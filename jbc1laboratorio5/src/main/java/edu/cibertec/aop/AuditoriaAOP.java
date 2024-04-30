/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Aspect
@Service
public class AuditoriaAOP {
    
    @Pointcut("execution(* edu.cibertec.beans.*.*(..))")
    public void principal(){  
        //AQUI AGREGAN SU LOGICA DE NEGOCIO
    }
    @Before("principal()")
    public void alertaAntes(JoinPoint jp){
        //AQUI AGREGAN SU LOGICA DE NEGOCIO
        System.out.println("Se ejecuto el metodo de auditoria antes de "+jp.getSignature()); 
    }
    @After("principal()")
    public void alertaDespues(JoinPoint jp){
        //AQUI AGREGAN SU LOGICA DE NEGOCIO
        System.out.println("Se ejecuto el metodo de auditoria despues de "+jp.getSignature()); 
    }
    
    @AfterThrowing("principal()")
    public void alertaExcepcion(JoinPoint jp){
        //AQUI AGREGAN SU LOGICA DE NEGOCIO
        System.out.println("Se ejecuto el metodo de auditoria despues de un error en "+jp.getSignature()); 
    }
    
    //@Around("principal()")
    public void alertaAround(JoinPoint jp){
        //AQUI AGREGAN SU LOGICA DE NEGOCIO
        System.out.println("Se ejecuto el metodo de auditoria alrededor de "+jp.getSignature()); 
    }
}
