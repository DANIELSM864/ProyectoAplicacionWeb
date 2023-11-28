package com.Anasovi.Anasovi.controller;

import com.Anasovi.Anasovi.domain.Consulta;
import com.Anasovi.Anasovi.service.ConsultaService;
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
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/paginaConsulta")
    public String listado(Model model) {
        var consultas = consultaService.getConsultas(false);
        model.addAttribute("consultas", consultas);

        return "/consulta/paginaConsulta";
    }

    @GetMapping("/nuevo")
    public String consultaNuevo(Consulta consulta) {
        return "/consulta/modifica";
    }

    @PostMapping("/guardar")
    public String consultaGuardar(Consulta consulta) {
        consultaService.save(consulta);
        return "redirect:/consulta/paginaConsulta";
    }
    

    @GetMapping("/eliminar/{idConsulta}")
    public String consultaEliminar(Consulta consulta) {
        consultaService.delete(consulta);
        return "redirect:/consulta/paginaConsulta";
    }
    @GetMapping("/ver/{idConsulta}")
    public String consultaModificar(Consulta consulta, Model model) {
        consulta = consultaService.getConsulta(consulta);
        model.addAttribute("consulta", consulta);
        return "/consulta/ver";
    }
}
