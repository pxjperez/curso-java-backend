/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
@SessionAttributes(value = {"usuario","path","metodo"})
public class UsuarioController {

    @Autowired //usuarioService= new UsuarioServiceImp();
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("accionLogin")
    public ModelAndView accionLogin(UsuarioEntity usuario, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        usuario = usuarioService.validarUsuario(usuario);
        ServletContext cxt=request.getServletContext();
        if (usuario == null) {
            mv.setViewName("login");
            mv.addObject("msgError", "Usuario o contraseña invalidos");
        } else {
            mv.addObject("usuario", usuario.getNombreApellido());
            mv.addObject("path", cxt.getContextPath());
            mv.addObject("metodo", request.getMethod());
            mv.setViewName("redirect:paginaPrincipal");
        }
        return mv;
    }

//    Forma 1
//    @RequestMapping("paginaPrincipal")
//    public ModelAndView paginaPrincipal(@RequestParam("usuario") String usuario, HttpSession sesion) {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("paginaPrincipal");
//        sesion.setAttribute("usuario", usuario);
//        //mv.addObject("usuario", usuario);
//        return mv;
//    }
    
//    Forma 2
//    @RequestMapping("paginaPrincipal")
//    public ModelAndView paginaPrincipal(@RequestParam("usuario") String usuario) {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("paginaPrincipal");
//        mv.addObject("usuario", usuario);
//        return mv;
//    }
    
    //Aqui utilizar el atributo de sesion que se mapeo en accionLogin
    @RequestMapping("paginaPrincipal")
    public ModelAndView paginaPrincipal() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("paginaPrincipal");
        return mv;
    }
    

    @RequestMapping("mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuarios(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mantenimientoUsuarios");
        //mv.addObject("usuario", request.getParameter("usuario"));
        mv.addObject("listaUsuarios", usuarioService.listarUsuario());
        return mv;
    }

    @RequestMapping("formularioNuevoUsuario")
    public ModelAndView formularioNuevoUsuario() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuarioBean", new UsuarioEntity());
        mv.setViewName("formularioNuevoUsuario");
        return mv;
    }
    
    @RequestMapping("grabarUsuario")
    //public ModelAndView grabarUsuario(@RequestParam(value = "archivo", required = false)CommonsMultipartFile archivo, @Valid @ModelAttribute("usuarioBean") UsuarioEntity usuario, BindingResult resultadoValidacion) {
    public ModelAndView grabarUsuario(@RequestParam(value = "archivo", required = false)MultipartFile archivo, @Valid @ModelAttribute("usuarioBean") UsuarioEntity usuario, BindingResult resultadoValidacion) {
        ModelAndView mv = new ModelAndView();        
        try {
            if(archivo.getSize()>0){
                usuario.setFoto(archivo.getBytes());
            }
            if (resultadoValidacion.hasErrors()) {
                mv.setViewName("formularioNuevoUsuario");
                mv.addObject("usuarioBean", usuario);
            }else{
                usuario.setEstado(1);
                Integer registos = usuarioService.insertarUsuario(usuario);
                if (registos > 0) {
                    mv.setViewName("redirect:mantenimientoUsuarios");
                } else {
                    mv.setViewName("formularioNuevoUsuario");
                    mv.addObject("usuarioBean", usuario);
                }
            }
        } catch (Exception ex) {
            mv.setViewName("formularioNuevoUsuario");
            mv.addObject("usuarioBean", usuario);
            mv.addObject("msgError", "Ocurrio un error al registrar lo datos intentelo nuevamente");
        }
        return mv;
    }

    @RequestMapping("eliminarUsuario")
    public ModelAndView eliminarUsuario(Integer idUsuario) {
        ModelAndView mv = new ModelAndView();
        try {
            usuarioService.eliminarUsuario(idUsuario);
            mv.setViewName("redirect:mantenimientoUsuarios");
        } catch (Exception ex) {
            mv.setViewName("mantenimientoUsuarios");
            mv.addObject("listaUsuarios", usuarioService.listarUsuario());
            mv.addObject("msgError", "No se puedo eliminar");
        }

        return mv;
    }

}
