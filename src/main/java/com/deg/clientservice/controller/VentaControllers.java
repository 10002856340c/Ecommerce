/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deg.clientservice.controller;

import com.deg.clientservice.controller.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.VentaModel;
import com.deg.clientservice.model.VentaModel.venta;
import com.deg.clientservice.service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
public class VentaControllers {



@RequestMapping(path = "api/venta")
@RestController
public class VentaController {

    @Autowired
    private VentaService ventaService;


    @PostMapping("/")
    public ResponseEntity<VentaModel> create(@RequestBody venta){
        return new ResponseEntity<>(this.ventaService.create(venta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<VentaModel>> findAll(){
        return new ResponseEntity<>(this.ventaService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaModel> update(@RequestBody VentaModel ventamodelUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ventaService.update(ventamodelUpdate, id), HttpStatus.OK);
    }
}
}
