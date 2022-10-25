package com.deg.clientservice.service;

import com.deg.clientservice.controller.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.clienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.deg.clientservice.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public clienteModel create (clienteModel newClient){
        return this.clienteRepository.save(newClient);
    }

//metodo para traer todos los datos
    public List<clienteModel> findAll(){
        return this.clienteRepository.findAll();
    }


//metodo para actualizar o cargar
    public clienteModel update(clienteModel client, Long id) throws ResourceNotFoundException {
        Optional<clienteModel> clientBD = this.clienteRepository.findById(id);
        if (clientBD.isPresent()){
            clienteModel c = clientBD.get();
            c.setApellido(client.getApellido());
            c.setNombre(client.getNombre());
            c.setDni(client.getDni()); 
            c.setFecha_nacimiento(client.getFecha_nacimiento());
            return this.clienteRepository.save(c);
        }else{
            throw new ResourceNotFoundException("El cliente no existe");
        }
    }

//metodo para eliminar
    public void delete(Long id){
        this.clienteRepository.deleteById(id);
    }
}
