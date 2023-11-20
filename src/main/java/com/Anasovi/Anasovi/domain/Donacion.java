
package com.Anasovi.Anasovi.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "donadores")
public class Donacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cedula")
    private Long cedula;
    
    private String nombre;
    
    @Column(name = "primer_apellido")
    private String primerApellido;
    
    @Column(name = "segundo_apellido")
    private String segundoApellido;

}

