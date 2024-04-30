/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service.impl;

import edu.cibertec.entity.AuditoriaEntity;
import edu.cibertec.entity.MatriculaEntity;
import edu.cibertec.repository.AuditoriaRepository;
import edu.cibertec.repository.MatriculaRepositry;
import edu.cibertec.service.MatriculaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpere
 */
@Service
public class MatriculaServiceImpl implements MatriculaService{

    @Autowired
    private  MatriculaRepositry matriculaRepository;
    @Autowired
    private  AuditoriaRepository auditoriaRepositoory;
    
    @Override
    public List<MatriculaEntity> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public MatriculaEntity grabarMatricula(MatriculaEntity matricula) {
        MatriculaEntity me=matriculaRepository.save(matricula);
        //AuditoriaEntity ae=new AuditoriaEntity(new Date(), null, "SE INSERTO LA MATRICULA "+me.getIdMatricula()); //CON EL ERROR
        AuditoriaEntity ae=new AuditoriaEntity(new Date(), me.getUsuario(), "SE INSERTO LA MATRICULA "+me.getIdMatricula()); // SIN EL ERROR 
        ae = auditoriaRepositoory.save(ae);      
        return me;
    }
    
}
