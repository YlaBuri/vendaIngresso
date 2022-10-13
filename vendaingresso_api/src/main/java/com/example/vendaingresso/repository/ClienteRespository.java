package com.example.vendaingresso.repository;


import com.example.vendaingresso.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespository extends JpaRepository<Cliente, Long> {


}
