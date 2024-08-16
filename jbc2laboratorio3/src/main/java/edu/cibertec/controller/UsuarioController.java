/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
public class UsuarioController {
    
    @Autowired //usuarioService= new UsuarioServiceImp();
    private UsuarioService usuarioService;
    
    
    @RequestMapping("/")
    public String login(){
        return "login";
    }
    @RequestMapping("accionLogin")
    public ModelAndView accionLogin(UsuarioEntity usuario){
        ModelAndView mv = new ModelAndView();
        usuario = usuarioService.validarUsuario(usuario);
        if(usuario==null){
            mv.setViewName("login");
            mv.addObject("msgError","Usuario o contraseña invalidos");
        }else{
            mv.setViewName("paginaPrincipal");
            mv.addObject("usuario",usuario);
            mv.addObject("listaUsuarios",usuarioService.listarUsuario());
        }        
        return mv;
    }
    
    @RequestMapping("eliminarUsuario")
    public ModelAndView eliminarUsuario(Integer idUsuario){
        ModelAndView mv = new ModelAndView();
        try{
            usuarioService.eliminarUsuario(idUsuario);
            mv.setViewName("paginaPrincipal");
            mv.addObject("usuario","");
            mv.addObject("listaUsuarios",usuarioService.listarUsuario());
        }catch(Exception ex){
            mv.setViewName("paginaPrincipal");
            mv.addObject("usuario","");
            mv.addObject("listaUsuarios",usuarioService.listarUsuario());
            mv.addObject("msgError","No se puedo eliminar");
        }
        

        
        return mv;
    }
    
    
    
}
