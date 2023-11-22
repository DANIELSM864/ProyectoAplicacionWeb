package com.Anasovi.Anasovi.service.impl;

import com.Anasovi.Anasovi.dao.NoticiaDao;
import com.Anasovi.Anasovi.domain.Noticia;
import com.Anasovi.Anasovi.service.NoticiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticiaServiceImpl implements NoticiaService {

    @Autowired
    private NoticiaDao noticiaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Noticia> getNoticias(boolean activo) {
        var noticias = noticiaDao.findAll();
        
        return noticias;
    }

    @Override
    @Transactional(readOnly = true)
    public Noticia getNoticia(Noticia noticia) {
        return noticiaDao.findById(noticia.getId_noticia()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Noticia noticia) {
        noticiaDao.save(noticia);
    }

    @Override
    @Transactional
    public void delete(Noticia noticia) {
        noticiaDao.delete(noticia);
    }
}