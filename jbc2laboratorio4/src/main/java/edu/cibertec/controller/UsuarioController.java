/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.bean.Usuario;
import edu.cibertec.service.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    //Carga la vista del Login
    @RequestMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    //Realiza la accion de logear
    //La mas utilizada para interceptar los valores que vienen del request
    @RequestMapping("logear")
    public ModelAndView logear(Usuario usuario) {
        ModelAndView mv = new ModelAndView();
        if (usuario.getUser()!= null && usuario.getPassword()!= null) {
            usuario=usuarioService.validarLogin(usuario);
            if(usuario!=null){
                mv.addObject("usuario",usuario);
                mv.setViewName("index");
            }else{
                mv.addObject("msgError", "Usuario y contraseña no validos");
                mv.setViewName("login");
            }            
        }else{
            mv.addObject("msgError", "No se ingreso un Usuario y Password valido");
            mv.setViewName("login");
        }
        return mv;
    }
    
    //Carga la vista de Mantenimiento Usuario
    @RequestMapping("mantenimientoUsuario")
    public ModelAndView mantenimientoUsuario() {
        ModelAndView mv = new ModelAndView();        
        mv.addObject("listaUsuarios",usuarioService.listarUsuarios());
        mv.setViewName("mantenimientousuario");
        return mv;
    }
    
    //Carga la vista del formulario crear usuario
    @RequestMapping("crearUsuario")
    public String crearUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "crearusuario";
    }
    
    //Carga la vista del formulario editar usuario
    @RequestMapping("editarUsuario")
    public String crearUsuario(Integer idUsuario, Model model) {
        model.addAttribute("usuario",usuarioService.obtenerUsuario(idUsuario));
        return "editarusuario";
    }
    
    //Realiza la accion de registrar usuario
    @RequestMapping("registrarUsuario")
    public ModelAndView registrarUsuario(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult resutado) {
        ModelAndView mv = new ModelAndView();     
        if(resutado.hasErrors()){
            mv.addObject("usuario", usuario);
            mv.setViewName("crearusuario");
        }else{
            Integer contador=usuarioService.registrarUsuario(usuario);
            if(contador>=0){
               mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
               mv.setViewName("mantenimientousuario"); 
            }else{
                mv.addObject("usuario",usuario);
                mv.addObject("msgError","Ocurrio un error al registrar");
                mv.setViewName("crearusuario");
            }
        }
        return mv;
    }
    
    //Realiza la accion de actualizar usuario
    @RequestMapping("actualizarUsuario")
    public ModelAndView actualizarUsuario(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult resutado) {
        ModelAndView mv = new ModelAndView();     
        if(resutado.hasErrors()){
            mv.addObject("usuario", usuario);
            mv.setViewName("editarusuario");
        }else{
            Integer contador=usuarioService.actualizarUsuario(usuario);
            if(contador>=0){
               mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
               mv.setViewName("mantenimientousuario"); 
            }else{
                mv.addObject("usuario",usuario);
                mv.addObject("msgError","Ocurrio un error al registrar");
                mv.setViewName("editarusuario");
            }
        }
        return mv;
    }
    
    //Realiza la accion de eliminar usuario
    @RequestMapping("eliminarUsuario")
    public ModelAndView eliminarUsuario(Integer idUsuario) {
        ModelAndView mv = new ModelAndView();     
         Integer contador=usuarioService.eliminarUsuario(idUsuario);
            if(contador>=0){
               mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
               mv.setViewName("mantenimientousuario"); 
            }else{
                mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
                mv.addObject("msgError","No se pudo Elimianr el Registro");
                mv.setViewName("mantenimientousuario");
            }
        return mv;
    }
}
