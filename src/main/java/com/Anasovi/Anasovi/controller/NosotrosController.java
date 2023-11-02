package com.Anasovi.Anasovi.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("nosotros")
public class NosotrosController {

    @GetMapping("/paginaNosotros")
    public String inicio() {

        return "/nosotros/paginaNosotros";
    }
}
