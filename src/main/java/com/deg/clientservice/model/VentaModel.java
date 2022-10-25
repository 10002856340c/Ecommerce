
package com.deg.clientservice.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;



    
@Data
@Entity
@Table(name = "venta")
public class VentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(mappedBy = "venta_id")
    private Long id;
    private LocalDate fecha_alta ;
    private double total;

   @ManyToOne
    @JoinColumn(name = "id")
    private clienteModel cliente_id;

    
  
}

