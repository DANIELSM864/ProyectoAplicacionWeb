package com.Anasovi.Anasovi.controller;

import com.Anasovi.Anasovi.domain.Usuario;
import com.Anasovi.Anasovi.service.UsuarioService;
import com.Anasovi.Anasovi.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/paginaUsuario")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        
        return "/usuario/paginaUsuario";
    }

    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }
    @GetMapping("/nuevoD")
    public String usuarioNuevoD(Usuario usuario) {
        return "/usuario/agrega";
    }

    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario) {
        
        usuarioService.save(usuario,true);
        return "redirect:/usuario/paginaUsuario";
    }

    @GetMapping("/eliminar/{cedula}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/paginaUsuario";
    }

    @GetMapping("/modificar/{cedula}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}
