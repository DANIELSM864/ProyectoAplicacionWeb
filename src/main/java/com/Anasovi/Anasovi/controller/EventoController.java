
package com.Anasovi.Anasovi.controller;

import com.Anasovi.Anasovi.domain.Evento;
import com.Anasovi.Anasovi.service.EventoService;
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
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // Endpoint para obtener listado de eventos
    @GetMapping("/paginaEvento")
    public String listado(Model model) {
        var eventos = eventoService.getEventos(false);
        model.addAttribute("eventos", eventos);
        model.addAttribute("totalEventos", eventos.size());
        return "evento/paginaEvento"; // Ajusta el nombre de la vista según tu estructura
    }

    // Endpoint para crear una nueva evento
    @GetMapping("/nuevo")
    public String eventoNueva(Evento evento) {
        return "evento/agrega"; // Ajusta el nombre de la vista según tu estructura
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String eventoGuardar(Evento evento,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            eventoService.save(evento);
            evento.setRuta_imagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "evento",
                            evento.getId_eventos()));
        }
        eventoService.save(evento);
        return "redirect:/evento/paginaEvento"; // Redirige al listado de eventos después de guardar
    }

    // Endpoint para eliminar una evento
    @GetMapping("/eliminar/{id_eventos}")
    public String eventoEliminar(Evento evento) {
        eventoService.delete(evento);
        return "redirect:/evento/paginaEvento";// Redirige al listado de eventos después de eliminar
    }

    // Endpoint para modificar una evento existente
    @GetMapping("/modificar/{id_eventos}")
    public String eventoModificar(Evento evento, Model model) {
        evento = eventoService.getEvento(evento);
        model.addAttribute("evento", evento);
        return "evento/modifica"; // Ajusta el nombre de la vista según tu estructura
    }
}