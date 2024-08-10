package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.service.ProductoService;


@Controller
public class CarritoController {

    @Autowired
    private ProductoService productoService;
    @RequestMapping("/")
    public ModelAndView mostrarIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("listaProductosNuevos", productoService.listarNuevos());
        mv.addObject("listaProductos", productoService.listarProductos());
        return mv;
    }
    
}
