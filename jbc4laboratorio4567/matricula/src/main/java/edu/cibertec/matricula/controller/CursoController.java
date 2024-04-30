package edu.cibertec.matricula.controller;

import java.util.logging.Level;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import edu.cibertec.matricula.entity.CursoEntity;
import edu.cibertec.matricula.service.CursoService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


//@Log  //Utilizando lombok no neceisto definr la variable de log
@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;

    private Logger log = LoggerFactory.getLogger(CursoController.class);

    @RequestMapping("mantenimientoCursos")
    public ModelAndView mantenimientoCursos() {
        log.info("Abriendo el mantenimiento curso");
        return new ModelAndView("mantenimientoCurso","listaCursos",cursoService.listarCursos().stream().filter(c->c.getEstado()==1).collect(Collectors.toList()));
    }

    @RequestMapping("formularioGrabarCurso")
    public ModelAndView formularioGrabarCurso() {
        log.info("Abriendo el formulario grabar curso");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formularioGrabarCurso");
        mv.addObject("cursoBean", new CursoEntity());
        return mv;
    }

    @RequestMapping("formularioEditarCurso")
    public ModelAndView formularioEditarCurso(Integer idCurso) {
        log.info("Abriendo el formulario actualizar curso");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formularioEditarCurso");
        mv.addObject("cursoBean", cursoService.obtenerCurso(idCurso));
        return mv;
    }

    @RequestMapping("grabarCurso")
    public ModelAndView grabarCurso(@Valid @ModelAttribute("cursoBean") CursoEntity curso, BindingResult validador) {
        log.debug("Ejecutando la accion de grabar curso - debug");
        log.info("Ejecutando la accion de grabar curso - info");
        ModelAndView mv = new ModelAndView();
        if(validador.hasErrors()){
            //log.log(Level.SEVERE,"Se detecto algunos errores de los parametros del curso");
            //log.severe("Se detecto algunos errores de los parametros del curso");
            log.error("Se detecto algunos errores de los parametros del curso");
            mv.setViewName("formularioGrabarCurso");
            mv.addObject("cursoBean",curso);
            String msgError="";
            for(ObjectError obj: validador.getAllErrors()){
                msgError+=obj.getDefaultMessage()+", ";
            }
            mv.addObject("msgError",msgError);
        }else{
            curso= cursoService.guardarCurso(curso);
            if(curso!=null){
                mv.setViewName("mantenimientoCurso");
                mv.addObject("listaCursos",cursoService.listarCursos().stream().filter(c->c.getEstado()==1).collect(Collectors.toList()));
                mv.addObject("mensaje","Curso grabado correctamente");
                log.info("Se detecto algunos errores de los parametros del curso");
            }else{
                //log.log(Level.WARNING,"Se detecto algunos errores de los parametros del curso");
                //log.warning("Se detecto algunos errores de los parametros del curso");
                log.warn("Se detecto algunos errores de los parametros del curso");
                mv.setViewName("formularioGrabarCurso");
                mv.addObject("msgError","Ocurrio un error al grabar el curso, intentelo nuevamente");  
            }
        }
        
        return mv;
    }

    @RequestMapping("editarCurso")
    public ModelAndView editarCurso(@Valid @ModelAttribute("cursoBean") CursoEntity curso, BindingResult validador) {
        ModelAndView mv = new ModelAndView();
        if(validador.hasErrors()){
            mv.setViewName("formularioEditarCurso");
            mv.addObject("cursoBean",curso);
            String msgError="";
            for(ObjectError obj: validador.getAllErrors()){
                msgError+=obj.getDefaultMessage()+", ";
            }
            //mv.addObject("msgError",""msgError"");
        }else{
            curso= cursoService.actualizarCurso(curso);
            if(curso!=null){
                mv.setViewName("mantenimientoCurso");
                mv.addObject("listaCursos",cursoService.listarCursos().stream().filter(c->c.getEstado()==1).collect(Collectors.toList()));
                mv.addObject("mensaje","Curso grabado correctamente");
            }else{
                mv.setViewName("formularioEditarCurso");
                mv.addObject("msgError","Ocurrio un error al editar el curso, intentelo nuevamente");  
            }
        }
        
        return mv;
    }

    @RequestMapping("eliminarCurso")
    public ModelAndView eliminarCurso(Integer idCurso) {
        ModelAndView mv = new ModelAndView();
        CursoEntity ce = cursoService.eliminarCurso(idCurso);
        if(ce!=null&&ce.getEstado().equals(0)){
            mv.setViewName("mantenimientoCurso");
            mv.addObject("listaCursos",cursoService.listarCursos().stream().filter(c->c.getEstado()==1).collect(Collectors.toList()));
            mv.addObject("mensaje","Curso eliminado correctamente");
        }else{
            mv.setViewName("mantenimientoCurso");
            mv.addObject("listaCursos",cursoService.listarCursos().stream().filter(c->c.getEstado()==1).collect(Collectors.toList()));
            mv.addObject("msgError","Ocurrio un error al eliminar el curso");
        }
        
        return mv;
    }
    
    
    
}
