/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.service.CursoService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CursoController {
    @Autowired
    private CursoService cursoService;
    
    @RequestMapping("mantenimientoCursos")
    public String mantenimientoCursos(){
        return "mantenimientoCursos";
    }
    
    @RequestMapping("cursoBusqueda")
    public ModelAndView cursoBusqueda(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("mantenimientoCursos");
        String tipo=request.getParameter("tipo");
        if(tipo!=null){
            switch (tipo) {
                case "LISTAPORNOMBRECURSO":                    
                    mv.addObject("listaCursos",cursoService.listarCursosPorNombreCurso(request.getParameter("nombreCurso1")));
                    break;
                case "LISTAPORNOMBRECURSOYALUMNOSMINIMO":
                    mv.addObject("listaCursos",cursoService.listarCursosPorNombreCursoAndAlumnosMinimo(request.getParameter("nombreCurso2"),Integer.valueOf(request.getParameter("alumnosMinimo"))));
                    break;
                case "PORESTADO":
                    mv.addObject("listaCursos",cursoService.consultarPorEstado(Integer.valueOf(request.getParameter("estado"))));
                    break;
                case "ABIERTOINCOMPLETO":
                    mv.addObject("listaCursos",cursoService.abiertoIncompleto());
                    break;
                case "ABIERTOINCOMPLETONATIVO":
                    mv.addObject("listaCursos",cursoService.abiertoIncompletoNativo());
                    break;
                case "PORFECHA":
                    try{
                        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = formatter.parse(request.getParameter("fecha"));
                        mv.addObject("listaCursos",cursoService.consultarPorFecha(date));
                    }catch(Exception ex){
                        System.out.println("Ocurrio un error en la fecha");
                        mv.addObject("listaCursos",null);
                    }                    
                    break;
                case "FALTANTE":
                    mv.addObject("listaCursos",cursoService.consultarFaltantes(Integer.valueOf(request.getParameter("cantidad"))));
                    break;
                case "PORNOMBRE":
                    mv.addObject("listaCursos",cursoService.consultarPorNombre(request.getParameter("nombreCurso3")));
                    break;
                default:
                    throw new AssertionError();
            }
        }else{
            mv.addObject("listaCursos",null);
        }
        return mv;
    }
    
}
