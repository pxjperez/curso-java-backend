package edu.cibertec.matricula.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.matricula.entity.CursoEntity;
import edu.cibertec.matricula.service.CursoService;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @RequestMapping("mantenimientoCursos")
    public ModelAndView mantenimientoCursos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mantenimientoCursos");
        mv.addObject("cursoBean", new CursoEntity());
        mv.addObject("listaCursos", cursoService.listarCursos().stream().filter(c->c.getEstado()!=-1).collect(Collectors.toList()));
        return mv;
    }
    @RequestMapping("eliminarCurso")
    public ModelAndView eliminarCurso(Integer idCurso){
        ModelAndView mv = new ModelAndView();
        CursoEntity curso=cursoService.eliminarCruso(idCurso);
        if(curso!=null){
            mv.setViewName("redirect:/mantenimientoCursos");
        }else{
            mv.setViewName("redirect:/mantenimientoCursos?errorEliminar=Ocurrio un error al eliminar el curso");
        }
        
        return mv;
    }

    @RequestMapping("grabarCurso")
    //public ModelAndView grabarCurso(CursoEntity curso){ //Sin validacion automatica
    public ModelAndView grabarCurso(@Valid @ModelAttribute("cursoBean") CursoEntity curso, BindingResult validador){ //Con validacion automatia
        ModelAndView mv = new ModelAndView();
        if(validador.hasErrors()){
            mv.setViewName("mantenimientoCursos");
            mv.addObject("listaCursos", cursoService.listarCursos().stream().filter(c->c.getEstado()!=-1).collect(Collectors.toList()));
            mv.addObject("cursoBean",curso);
        }else{
            CursoEntity cursoRegistrado=cursoService.registrarCurso(curso);
            if(cursoRegistrado!=null){
                mv.setViewName("redirect:/mantenimientoCursos");
            }else{
                mv.setViewName("mantenimientoCursos");
                mv.addObject("listaCursos", cursoService.listarCursos().stream().filter(c->c.getEstado()!=-1).collect(Collectors.toList()));
                mv.addObject("errorGrabar","Ocurrio un error al grabar el curso");
            }  
        }
              
        return mv;
    }
}
