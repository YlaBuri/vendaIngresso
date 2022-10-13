package com.example.vendaingresso.service;

import com.example.vendaingresso.dto.CompraRequestDto;

import com.example.vendaingresso.model.Compra;
import com.example.vendaingresso.repository.ClienteRespository;
import com.example.vendaingresso.repository.CompraRepository;
import com.example.vendaingresso.repository.EventoRepository;
import com.example.vendaingresso.repository.PoltronaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompraService {

    CompraRepository compraRepository;
    ClienteRespository clienteRespository;
    EventoRepository eventoRepository;
    PoltronaRepository poltronaRepository;

    public CompraService(CompraRepository compraRepository, ClienteRespository clienteRespository, EventoRepository eventoRepository, PoltronaRepository poltronaRepository) {
        this.compraRepository = compraRepository;
        this.clienteRespository = clienteRespository;
        this.eventoRepository = eventoRepository;
        this.poltronaRepository = poltronaRepository;
    }

    public Compra inserir(CompraRequestDto compraRequestDto) {
        Compra compra = compraRequestDto.toModel(clienteRespository, eventoRepository, poltronaRepository);
        return compraRepository.save(compra);
    }


    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    public List<Compra> findByUsuario(Long clienteId) {
        return compraRepository.findAllByCliente_Id(clienteId);
    }
}
