package com.Anasovi.Anasovi.service.impl;

import com.Anasovi.Anasovi.dao.EventoDao;
import com.Anasovi.Anasovi.domain.Evento;
import com.Anasovi.Anasovi.service.EventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoDao eventoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Evento> getEventos(boolean activo) {
        var eventos = eventoDao.findAll();
        
        return eventos;
    }

    @Override
    @Transactional(readOnly = true)
    public Evento getEvento(Evento evento) {
        return eventoDao.findById(evento.getId_eventos()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Evento evento) {
        eventoDao.save(evento);
    }

    @Override
    @Transactional
    public void delete(Evento evento) {
        eventoDao.delete(evento);
    }
}