package com.example.vendaingresso.repository;

import com.example.vendaingresso.model.Cliente;
import com.example.vendaingresso.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
