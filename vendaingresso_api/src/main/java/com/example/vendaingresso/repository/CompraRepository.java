package com.example.vendaingresso.repository;

import com.example.vendaingresso.model.Cliente;
import com.example.vendaingresso.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByCliente_Id(Long cliente_id);
}
