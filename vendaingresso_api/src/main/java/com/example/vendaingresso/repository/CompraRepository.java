package com.example.vendaingresso.repository;

import com.example.vendaingresso.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Cliente, Long> {
}
