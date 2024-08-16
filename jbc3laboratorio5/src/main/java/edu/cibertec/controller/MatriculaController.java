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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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
    private MatriculaService matriculaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CursoService cursoService;
    
    @RequestMapping("mantenimientoMatriculas")
    public ModelAndView mantenimientoMatriculas(){
        ModelAndView mv = new ModelAndView("mantenimientoMatriculas", "listaMatriculas", matriculaService.listarMatriculas());
        mv.addObject("listaUsuarios", usuarioService.listarUsuario());
        mv.addObject("listaCursos", cursoService.abiertoIncompleto());        
        return mv;
    }
    
    @RequestMapping("grabarMatricula")
    public ModelAndView grabarMatricula(MatriculaEntity matricula, HttpServletRequest request){
        UsuarioEntity usuario= new UsuarioEntity();
        usuario.setIdUsuario(Integer.valueOf(request.getParameter("cbUsuario")));
        CursoEntity curso= new CursoEntity();
        curso.setIdCurso(Integer.valueOf(request.getParameter("cbCurso")));
        matricula.setUsuario(usuario);
        matricula.setCurso(curso);
        matricula=matriculaService.grabarMatricula(matricula);        
        ModelAndView mv = new ModelAndView("mantenimientoMatriculas", "listaMatriculas", matriculaService.listarMatriculas());
        mv.addObject("listaUsuarios", usuarioService.listarUsuario());
        mv.addObject("listaCursos", cursoService.abiertoIncompleto());
        if(matricula==null){
            mv.addObject("msgError", "Error al registrar matricula");
        }
                
        return mv;
    }
}
