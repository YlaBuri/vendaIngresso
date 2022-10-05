package com.example.vendaingresso.repository;

import com.example.vendaingresso.model.Poltrona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoltronaRepository extends JpaRepository<Poltrona, Long> {
}
