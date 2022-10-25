
package com.deg.clientservice.service;

import com.deg.clientservice.controller.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.VentaModel;
import com.deg.clientservice.repository.VentaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
        @Autowired
    private VentaRepository ventaRepository;

  public VentaModel create (VentaModel newventa){
        return this.ventaRepository.save(newventa);
    }

//metodo para traer todos los datos
    public List<VentaModel> findAll(){
        return this.ventaRepository.findAll();
    }


//metodo para actualizar o cargar
    public VentaModel update(VentaModel client, Long id) throws ResourceNotFoundException {
        Optional<VentaModel> clientBD = this.ventaRepository.findById(id);
        if (clientBD.isPresent()){
            VentaModel c = clientBD.get();
            return c;
        }else{
            throw new ResourceNotFoundException("La venta no existe");
        }
    }

//metodo para eliminar
    public void delete(Long id){
        this.ventaRepository.deleteById(id);
    }
}
