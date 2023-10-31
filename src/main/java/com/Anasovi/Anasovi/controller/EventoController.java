
package com.Anasovi.Anasovi.controller;

/**
 *
 * @author douglas
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/evento")
public class EventoController {

    @GetMapping("/paginaEvento")
    public String inicio() {

        return "evento/paginaEvento";
    }
}
