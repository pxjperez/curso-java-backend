/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.service.CursoService;
import java.sql.Date;
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

    @RequestMapping("cursoBusqueda")
    public String cursoBusqueda() {
        return "cursoBusqueda";
    }

    @RequestMapping("accionBuscarCurso")
    public ModelAndView cursoBusqueda(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("cursoBusqueda");
        String tipoConsulta = request.getParameter("tipo");
        if (tipoConsulta != null) {
            switch (tipoConsulta) {
                case "estado":
                    Integer estado = Integer.parseInt(request.getParameter("estado"));
                    mv.addObject("listaCurso", cursoService.consultarPorEstado(estado));
                    break;
                case "incompleto":
                    mv.addObject("listaCurso", cursoService.abiertoIncompleto());
                    break;
                case "fecha":
                    Date fecha = Date.valueOf(request.getParameter("fecha"));
                    mv.addObject("listaCurso", cursoService.consultarPorFecha(fecha));
                    break;
                case "faltante":
                    Integer faltante = Integer.parseInt(request.getParameter("faltante"));
                    mv.addObject("listaCurso", cursoService.consultarPorFaltantes(faltante));
                    break;
                case "nombre":
                    String cadena = request.getParameter("cadena");
                    mv.addObject("listaCurso", cursoService.consultarPorNombre(cadena));
                    break;
            }
        }else{
            mv.addObject("msgError", "Estimado usuario por favor seleccione un tipo de busqueda");
            
        }

        return mv;
    }

}
