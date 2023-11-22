package com.Anasovi.Anasovi.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "noticias")
public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_noticia")
    private Long id_noticia;
    
    private String descripcion;
    
    private String ruta_imagen;



    public Noticia() {

    }
public Noticia(Long id_noticia, String descripcion, String ruta_imagen) {
        this.id_noticia = id_noticia;
        this.descripcion = descripcion;
        this.ruta_imagen = ruta_imagen;
        
    }
}