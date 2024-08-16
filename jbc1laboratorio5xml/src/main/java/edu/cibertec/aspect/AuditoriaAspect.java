/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.aspect;

import edu.cibertec.bean.HolaMundo;
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
@Service
public class AuditoriaAspect {
    public void main(){
        System.out.println("Punto de inicio de la Auditoria");
    }
    
    public void alertaAntes (JoinPoint jp){
        System.out.println("Auditoria antes de ejecutar el mentodo: "+jp.getSignature().getName());
    }
    
    public void alertaDespues (JoinPoint jp){
        System.out.println("Auditoria despues de ejecutar el mentodo: "+jp.getSignature().getName());
        Object[] args = jp.getArgs();

        // Imprimimos los argumentos
        System.out.println("Argumentos del método: "+jp.getSignature().getName());
        for (Object arg : args) {
            //HolaMundo ho = (HolaMundo) arg;
            System.out.println(arg);
        }
    }
    
    public void durante (JoinPoint jp){
        System.out.println("Auditoria durante de ejecutar el mentodo: "+jp.getSignature().getName());
    }
    
    public void alertaExcepciones(JoinPoint jp, Throwable  ex){
            System.out.println("Ocurrio un error en el metodo "+jp.getSignature().getName()+". Error: "+ex.getMessage());
    }
}
