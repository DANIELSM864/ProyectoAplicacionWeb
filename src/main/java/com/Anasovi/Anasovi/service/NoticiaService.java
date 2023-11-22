/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Anasovi.Anasovi.service;

import com.Anasovi.Anasovi.domain.Noticia;
import java.util.List;


public interface NoticiaService {


    public List<Noticia> getNoticias(boolean activos);

    public Noticia getNoticia(Noticia noticia);

    public void save(Noticia noticia);

    public void delete(Noticia noticia);
}
