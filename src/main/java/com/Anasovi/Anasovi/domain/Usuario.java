package com.Anasovi.Anasovi.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cedula")
    private Long cedula;
    private String username;
    private String password;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private boolean activo;

    
    
    @OneToMany
    @JoinColumn(name="cedula", updatable=false)
    private List<Rol> roles;
}
