/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deg.clientservice.repository;

import com.deg.clientservice.model.Clientes;
import com.deg.clientservice.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USUARIO
 */
public interface ProductoRepository extends JpaRepository<Productos,Long> {
    
}
