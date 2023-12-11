package com.Anasovi.Anasovi.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="factura")
public class Factura implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private Long idFactura;
    private Long cedula;
    private Date fechaFactura;
    private double totalCompra;
    
    
    public Factura() {
    }

    public Factura(Long cedula) {
        this.cedula = cedula;
        this.fechaFactura = Calendar.getInstance().getTime();
        
    }    
}
