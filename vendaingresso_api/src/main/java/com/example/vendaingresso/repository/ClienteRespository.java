package com.example.vendaingresso.repository;


import com.example.vendaingresso.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRespository extends PagingAndSortingRepository<Cliente, Long> {


}
