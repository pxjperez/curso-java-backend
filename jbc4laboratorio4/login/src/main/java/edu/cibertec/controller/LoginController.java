package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class LoginController {
    @RequestMapping("/")
    public String Login(){
        return "login";
    }

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @Autowired
    private UsuarioService usuarioservice;

    @RequestMapping("accionLogin")
    public ModelAndView validarLogin(UsuarioEntity usuario){
        ModelAndView mav = new ModelAndView();
        UsuarioEntity user = usuarioservice.validarUsuario(usuario);
        if(user!=null){
            mav.addObject("usuario", user.getNombreApellido());
            mav.setViewName("paginaPrincipal");
            mav.addObject("mensaje", mensajeBienvenida);
        }else{
            mav.setViewName("login");
            mav.addObject("msgError", "Credenciales incorrectas");
        }
        return mav;
    }

    @RequestMapping("mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuarios(){
        ModelAndView mav = new ModelAndView("mantenimientoUsuarios");
        mav.addObject("listaUsuarios", usuarioservice.listarUsuario());
        mav.addObject("cantidadPaginas", 1);
        return mav;
    }
}
