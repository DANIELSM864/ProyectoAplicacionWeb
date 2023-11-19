package com.Anasovi.Anasovi.controller;

import com.Anasovi.Anasovi.domain.Donacion;
import com.Anasovi.Anasovi.service.DonacionService;

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
@RequestMapping("/donacion")
public class DonacionController {

    @Autowired
    private DonacionService donacionService;

    @GetMapping("/paginaDonacion")
    public String listado(Model model) {
        var donacions = donacionService.getDonacions(false);
        model.addAttribute("donacions", donacions);
        model.addAttribute("totalDonacions", donacions.size());

        return "/donacion/paginaDonacion";
    }

    @GetMapping("/nuevo")
    public String donacionNuevo(Donacion donacion) {
        return "/donacion/modifica";
    }

    @PostMapping("/guardar")
    public String donacionGuardar(Donacion donacion) {
        donacionService.save(donacion);
        return "redirect:/donacion/paginaDonacion";
    }

    @GetMapping("/eliminar/{cedula}")
    public String donacionEliminar(Donacion donacion) {
        donacionService.delete(donacion);
        return "redirect:/donacion/paginaDonacion";
    }

    @GetMapping("/modificar/{cedula}")
    public String donacionModificar(Donacion donacion, Model model) {
        donacion = donacionService.getDonacion(donacion);
        model.addAttribute("donacion", donacion);
        return "/donacion/modifica";
    }

}
