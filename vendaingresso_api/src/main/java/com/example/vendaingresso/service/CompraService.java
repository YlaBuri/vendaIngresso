package com.example.vendaingresso.service;

import com.example.vendaingresso.dto.CompraRequestDto;

import com.example.vendaingresso.model.Compra;
import com.example.vendaingresso.repository.ClienteRespository;
import com.example.vendaingresso.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompraService {

    CompraRepository compraRepository;
    ClienteRespository clienteRespository;

    public CompraService(CompraRepository compraRepository, ClienteRespository clienteRespository) {
        this.compraRepository = compraRepository;
        this.clienteRespository = clienteRespository;
    }

    public Compra inserir(CompraRequestDto compraRequestDto) {
        Compra compra = compraRequestDto.toModel(clienteRespository);
        return compra;
    }


    public List<Compra> findAll() {
        return compraRepository.findAll();
    }
}
