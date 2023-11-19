/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Anasovi.Anasovi.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "donadores")
public class Donacion implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cedula")
    private Long cedula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

}
