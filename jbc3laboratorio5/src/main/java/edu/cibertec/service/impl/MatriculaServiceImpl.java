/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service.impl;

import edu.cibertec.entity.AuditoriaEntity;
import edu.cibertec.entity.MatriculaEntity;
import edu.cibertec.repository.AuditoriaRepository;
import edu.cibertec.repository.MatriculaRepository;
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
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AuditoriaRepository auditoriaRepository;
    
    @Override
    public List<MatriculaEntity> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public MatriculaEntity grabarMatricula(MatriculaEntity matriculaEntity) {
        matriculaEntity=matriculaRepository.save(matriculaEntity);
        AuditoriaEntity auditoria = new AuditoriaEntity(new Date(),matriculaEntity.getUsuario(), "Insertando la matricula"+matriculaEntity.getIdMatricula());
        auditoriaRepository.save(auditoria);
        return matriculaEntity;
    }
    
}
