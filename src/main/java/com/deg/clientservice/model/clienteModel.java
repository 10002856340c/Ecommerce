package com.deg.clientservice.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
public class clienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    @OneToMany(mappedBy = "cliente_id")
    private List<VentaModel> ventas;

}
