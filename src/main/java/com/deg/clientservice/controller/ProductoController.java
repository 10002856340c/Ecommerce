
package com.deg.clientservice.controller;

import com.deg.clientservice.controller.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.Productos;
import com.deg.clientservice.service.ProductoService;
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

@RequestMapping(path = "api/productos")
@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoservice;


    @PostMapping("/")
    public ResponseEntity<Productos> create(@RequestBody Productos producto){
        return new ResponseEntity<>(this.productoservice.create(producto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Productos>> findAll(){
        return new ResponseEntity<>(this.productoservice.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> update(@RequestBody Productos productoUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.productoservice.update(productoUpdate, id), HttpStatus.OK);
    }
}
