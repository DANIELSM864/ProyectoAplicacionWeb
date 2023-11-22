package com.Anasovi.Anasovi.controller;

import com.Anasovi.Anasovi.domain.Noticia;
import com.Anasovi.Anasovi.service.NoticiaService;
import com.Anasovi.Anasovi.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/noticia")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    // Endpoint para obtener listado de noticias
    @GetMapping("/paginaNoticia")
    public String listado(Model model) {
        var noticias = noticiaService.getNoticias(false);
        model.addAttribute("noticias", noticias);
        model.addAttribute("totalNoticias", noticias.size());
        return "noticia/paginaNoticia"; // Ajusta el nombre de la vista según tu estructura
    }

    // Endpoint para crear una nueva noticia
    @GetMapping("/nuevo")
    public String noticiaNueva(Noticia noticia) {
        return "noticia/agrega"; // Ajusta el nombre de la vista según tu estructura
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String noticiaGuardar(Noticia noticia,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            noticiaService.save(noticia);
            noticia.setRuta_imagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "noticia",
                            noticia.getId_noticia()));
        }
        noticiaService.save(noticia);
        return "redirect:/noticia/paginaNoticia"; // Redirige al listado de noticias después de guardar
    }

    // Endpoint para eliminar una noticia
    @GetMapping("/eliminar/{id_noticia}")
    public String noticiaEliminar(Noticia noticia) {
        noticiaService.delete(noticia);
        return "redirect:/noticia/paginaNoticia";// Redirige al listado de noticias después de eliminar
    }

    // Endpoint para modificar una noticia existente
    @GetMapping("/modificar/{id_noticia}")
    public String noticiaModificar(Noticia noticia, Model model) {
        noticia = noticiaService.getNoticia(noticia);
        model.addAttribute("noticia", noticia);
        return "noticia/modifica"; // Ajusta el nombre de la vista según tu estructura
    }
}
