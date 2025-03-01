package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.service.ProductoService;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("listaProductos", productoService.listarProductos());
        return mv;
    }
}
