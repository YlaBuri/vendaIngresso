package com.example.vendaingresso.repository;

import com.example.vendaingresso.model.Cliente;
import com.example.vendaingresso.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
