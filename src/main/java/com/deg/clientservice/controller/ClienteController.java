package com.deg.clientservice.controller;

import com.deg.clientservice.controller.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.clienteModel;
import com.deg.clientservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/")
    public ResponseEntity<clienteModel> create(@RequestBody clienteModel client){
        return new ResponseEntity<>(this.clienteService.create(client), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<clienteModel>> findAll(){
        return new ResponseEntity<>(this.clienteService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<clienteModel> update(@RequestBody clienteModel clientUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.clienteService.update(clientUpdate, id), HttpStatus.OK);
    }
}
