/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Anasovi.Anasovi.service;

import com.Anasovi.Anasovi.domain.Evento;
import java.util.List;


public interface EventoService {


    public List<Evento> getEventos(boolean activos);

    public Evento getEvento(Evento evento);

    public void save(Evento evento);

    public void delete(Evento evento);
}
