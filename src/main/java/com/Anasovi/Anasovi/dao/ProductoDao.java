/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Anasovi.Anasovi.dao;

import com.Anasovi.Anasovi.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao 
        extends JpaRepository <Producto, Long>{

}