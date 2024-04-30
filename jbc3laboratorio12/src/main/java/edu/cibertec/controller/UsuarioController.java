/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.controller;

import edu.cibertec.entity.UsuarioEntity;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
/**
 *
 * @author jpere
 */
@Controller
@SessionAttributes(value = {"usuario"})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("mantenimientoUsuario")
    public String mantenimientoUsuario(Model modelo) {
        modelo.addAttribute("listaUsuarios", usuarioService.listarUsuario());
        return "mantenimientousuario";
    }

    @RequestMapping("mostrarCreaUsuario")
    public ModelAndView mostrarCreaUsuario() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("crearusuario");
        mv.addObject("usuario", new UsuarioEntity());
        return mv;
    }
    
    @RequestMapping("mostrarEditarUsuario")
    public String mostrarEditarUsuario(Integer idUsuario, Model model) {
        model.addAttribute("usuario", usuarioService.obtenerUsuario(idUsuario));
        return "editarusuario";
    }
    

    @RequestMapping(value = "registrarUsuario", consumes = MULTIPART_FORM_DATA_VALUE)
    //Tener cuidado al momento de usar CommonsMultipartFile se utiliza solo cuando vamos a enviar archivos cuando conbinamos datos con archivos es MultipartFile
    public ModelAndView registrarUsuario(@RequestParam(value = "archivo", required = false)  MultipartFile archivo, @Valid @ModelAttribute("usuario") UsuarioEntity usuarioEntity, BindingResult respuesta) {
        ModelAndView mv = new ModelAndView();
        try {
            if (respuesta.hasErrors()) {
                mv = new ModelAndView("crearusuario", "usuario", usuarioEntity);
            } else {
                if (archivo != null) {
                    usuarioEntity.setFoto(archivo.getBytes());
                }
                UsuarioEntity resultado = usuarioService.agregarUsuario(usuarioEntity);
                if (resultado != null) {
                    mv.setViewName("mantenimientousuario");
                    mv.addObject("listaUsuarios", usuarioService.listarUsuario());
                } else {
                    mv.setViewName("crearusuario");
                    mv.addObject("usuario", usuarioEntity);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            mv.setViewName("crearusuario");
            mv.addObject("usuario", usuarioEntity);
        }

        return mv;
    }
    
    //Realiza la accion de actualizar usuario
    @RequestMapping(value = "actualizarUsuario", consumes = MULTIPART_FORM_DATA_VALUE)
    public ModelAndView actualizarUsuario(@RequestParam(value = "archivo", required = false) MultipartFile archivo, @Valid @ModelAttribute("usuario") UsuarioEntity usuario, BindingResult respuesta, HttpSession sesion) {
        ModelAndView mv = new ModelAndView();
        UsuarioEntity usuarioEntity=null;
        try {
            if (archivo != null) {
                usuario.setFoto(archivo.getBytes());
            }
            if (respuesta.hasErrors()) {
                mv.addObject("usuario", usuario);
                mv.setViewName("editarusuario");
            } else {
                usuarioEntity = usuarioService.actualizarUsuario(usuario);
                if (usuarioEntity!=null) {
                    mv.addObject("listaUsuarios", usuarioService.listarUsuario());
                    mv.setViewName("mantenimientousuario");
                } else {
                    mv.addObject("usuario", usuario);
                    mv.addObject("msgError", "Ocurrio un error al registrar");
                    mv.setViewName("editarusuario");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            mv.addObject("usuario", usuario);
            mv.addObject("msgError", "Ocurrio un error al registrar");
            mv.setViewName("editarusuario");
        }
        return mv;
    }

    //Realiza la accion de eliminar usuario
    @RequestMapping("eliminarUsuario")
    public ModelAndView eliminarUsuario(Integer idUsuario, Model modelo) {
        ModelAndView mv = new ModelAndView();
        Integer contador = usuarioService.eliminarUsuario(idUsuario);
        if (contador >= 0) {
            mv.addObject("listaUsuarios", usuarioService.listarUsuario());
            mv.setViewName("mantenimientousuario");
        } else {
            mv.addObject("listaUsuarios", usuarioService.listarUsuario());
            mv.addObject("msgError", "No se pudo Elimianr el Registro");
            mv.setViewName("mantenimientousuario");
        }
        return mv;
    }
    
    //Muestra una foto
    @RequestMapping("mostrarFoto")
    public String mostrarFoto(HttpServletRequest request, Model modelo) {
        UsuarioEntity usuario = usuarioService.obtenerUsuario(Integer.parseInt(request.getParameter("idUsuario")));
        modelo.addAttribute("usuario", usuario);
        return "fotousuario";
    }
}
