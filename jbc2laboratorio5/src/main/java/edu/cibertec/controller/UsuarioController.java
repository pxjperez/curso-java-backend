/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.bean.Usuario;
import edu.cibertec.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jpere
 */
@Controller
@SessionAttributes({"usuario","contador"}) // Esta anotacion nos permite especificar que cualquier atributo que se defina con este nombre va a ser una sesion
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
    public ModelAndView logear(Usuario usuario) {//Si quiere trabajar con la sesion sin la anotacion agregan HttpSession sesion entrada en el metodo
        ModelAndView mv = new ModelAndView();
        if (usuario.getUser()!= null && usuario.getPassword()!= null) {
            usuario=usuarioService.validarLogin(usuario);
            if(usuario!=null){
                //sesion.setAttribute("usuario", usuario);  //Descomentar esta linea si se quiere trabajar la sesion sin la anotacion
                mv.addObject("usuario",usuario); //Comentar esta linea si se quiere trabajar la sesion sin la anotacion
                mv.addObject("contador",0);
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
    public ModelAndView registrarUsuario(@RequestParam(value = "archivo", required = false)CommonsMultipartFile archivo,@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult resutado,HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();  
        if(archivo!=null){
          usuario.setFoto(archivo.getBytes());  
        }
        if(resutado.hasErrors()){
            mv.addObject("usuario", usuario);
            mv.setViewName("crearusuario");
        }else{
            Integer contador=usuarioService.registrarUsuario(usuario);
            if(contador>=0){
               mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
               Integer contadorSesion = Integer.valueOf(request.getSession().getAttribute("contador").toString());
               contadorSesion++;
               mv.addObject("contador", contadorSesion);
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
    public ModelAndView actualizarUsuario(@RequestParam(value = "archivo", required = false)CommonsMultipartFile archivo,@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult resutado,HttpSession sesion) {
        ModelAndView mv = new ModelAndView();   
        if(archivo!=null){
          usuario.setFoto(archivo.getBytes());  
        }
        if(resutado.hasErrors()){
            mv.addObject("usuario", usuario);
            mv.setViewName("editarusuario");
        }else{
            Integer contador=usuarioService.actualizarUsuario(usuario);
            if(contador>=0){
               mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
               Integer contadorSesion = Integer.valueOf(sesion.getAttribute("contador").toString());
               contadorSesion++;
               mv.addObject("contador", contadorSesion);
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
    public ModelAndView eliminarUsuario(Integer idUsuario,Model modelo) {
        ModelAndView mv = new ModelAndView();     
         Integer contador=usuarioService.eliminarUsuario(idUsuario);
            if(contador>=0){
               mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
               Integer contadorSesion = Integer.valueOf(modelo.getAttribute("contador").toString());
               contadorSesion++;
               mv.addObject("contador", contadorSesion);
               mv.setViewName("mantenimientousuario"); 
            }else{
                mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
                mv.addObject("msgError","No se pudo Elimianr el Registro");
                mv.setViewName("mantenimientousuario");
            }
        return mv;
    }
    
    //Muestra una foto
    @RequestMapping("mostrarFoto")
    public String mostrarFoto(HttpServletRequest request, Model modelo){
        modelo.addAttribute("usuario", usuarioService.obtenerUsuario(Integer.parseInt(request.getParameter("idUsuario"))));
        return "fotousuario";
    }
}
