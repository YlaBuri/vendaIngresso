package com.example.vendaingresso.repository;

import com.example.vendaingresso.model.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {


}
