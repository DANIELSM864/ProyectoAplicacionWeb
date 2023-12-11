package com.Anasovi.Anasovi.dao;

import com.Anasovi.Anasovi.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository <Factura,Long> {
     
}
