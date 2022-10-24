package com.deg.clientservice.model;

import java.time.LocalDate;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;

}
