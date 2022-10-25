package com.deg.clientservice.repository;

import com.deg.clientservice.model.clienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<clienteModel,Long> {
}
