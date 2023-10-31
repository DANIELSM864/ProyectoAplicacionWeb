/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Anasovi.Anasovi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author danis
 */
@Controller
@Slf4j
@RequestMapping("/donacion")
public class DonacionController {

    @GetMapping("/paginaDonacion")
    public String inicio() {

        return "/donacion/paginaDonacion";
    }
}
