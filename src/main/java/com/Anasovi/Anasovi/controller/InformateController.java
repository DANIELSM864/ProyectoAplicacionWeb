package com.Anasovi.Anasovi.controller;

/**
 *
 * @author diego
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/informate")
public class InformateController {

    @GetMapping("/paginaInformate")
    public String inicio() {

        return "/informate/paginaInformate";
    }
}