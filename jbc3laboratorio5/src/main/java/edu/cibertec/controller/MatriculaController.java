/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.entity.MatriculaEntity;
import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.CursoService;
import edu.cibertec.service.MatriculaService;
import edu.cibertec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
@SessionAttributes(value = {"usuario"})
public class MatriculaController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private MatriculaService matriculaService;

    @RequestMapping("mostraMatricula")
    public ModelAndView mostraMatricula() {
        ModelAndView mv = new ModelAndView("matricula");
        mv.addObject("listaUsuarios", usuarioService.listarUsuario());
        mv.addObject("listaCursos", cursoService.abiertoIncompleto());
        mv.addObject("listaMatriculas", matriculaService.listarMatriculas());
        return mv;
    }

    @RequestMapping("grabarMatricula")
    public ModelAndView grabarMatricula(MatriculaEntity matricula, Integer idUsuario, Integer idCurso) {
        UsuarioEntity ue = new UsuarioEntity();
        ue.setIdUsuario(idUsuario);
        CursoEntity ce = new CursoEntity();
        ce.setIdCurso(idCurso);
        matricula.setUsuario(ue);
        matricula.setCurso(ce);
        try {
            MatriculaEntity me = matriculaService.grabarMatricula(matricula);
            if (me != null) {
                return new ModelAndView("redirect:mostraMatricula");
            } else {
                ModelAndView mv = new ModelAndView("matricula");
                mv.addObject("listaUsuarios", usuarioService.listarUsuario());
                mv.addObject("listaCursos", cursoService.abiertoIncompleto());
                mv.addObject("listaMatriculas", matriculaService.listarMatriculas());
                mv.addObject("matricula", matricula);
                mv.addObject("idUsuario", idUsuario);
                mv.addObject("idCurso", idCurso);
                mv.addObject("msgError", "No se pudo grabar correctamente");
                return mv;
            }
        }catch(Exception ex){
                ModelAndView mv = new ModelAndView("matricula");
                mv.addObject("listaUsuarios", usuarioService.listarUsuario());
                mv.addObject("listaCursos", cursoService.abiertoIncompleto());
                mv.addObject("listaMatriculas", matriculaService.listarMatriculas());
                mv.addObject("matricula", matricula);
                mv.addObject("idUsuario", idUsuario);
                mv.addObject("idCurso", idCurso);
                mv.addObject("msgError", "No se pudo grabar correctamente por que ocurrio un erro en: "+ex.getMessage());
                return mv;
        }

    }

}
