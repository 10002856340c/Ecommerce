package com.deg.clientservice.service;

import com.deg.clientservice.controller.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.Clientes;
import com.deg.clientservice.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.deg.clientservice.repository.ClienteRepository;
import com.deg.clientservice.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productosRepository;


//metodo para crear
    public Productos create (Productos newProductos){
        return this.productosRepository.save(newProductos);
    }

//metodo para traer todos los datos
    public List<Productos> findAll(){
        return this.productosRepository.findAll();
    }


//metodo para actualizar o cargar
    public Productos update(Productos producto, Long id) throws ResourceNotFoundException {
        Optional<Productos> productoBD = this.productosRepository.findById(id);
        if (productoBD.isPresent()){
            Productos p = productoBD.get();
               p.setSku(producto.getSku());
               p.setDescripcion(producto.getDescripcion());
               p.setPrecio_compra(producto.getPrecio_compra());
               p.setPrecio_venta(producto.getPrecio_venta());
               p.setStock(producto.getStock());
               p.setFecha_alta(producto.getFecha_alta());
           return this.productosRepository.save(p);
  
        }else{
            throw new ResourceNotFoundException("El producto no existe");
        }
    }

//metodo para eliminar
    public void delete(Long id){
        this.productosRepository.deleteById(id);
    }
}
