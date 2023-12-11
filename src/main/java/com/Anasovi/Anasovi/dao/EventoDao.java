
package com.Anasovi.Anasovi.dao;

import com.Anasovi.Anasovi.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoDao 
        extends JpaRepository <Evento, Long>{

}