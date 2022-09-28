package com.example.vendaingresso.service;


import com.example.vendaingresso.dto.ClienteRequestDto;
import com.example.vendaingresso.model.Cliente;
import com.example.vendaingresso.repository.ClienteRespository;
import com.example.vendaingresso.repository.EnderecoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRespository clienteRepository;

    private final EnderecoRepository enderecoRepository;

    public ClienteService(ClienteRespository clienteRespository, EnderecoRepository enderecoRepository){
        this.clienteRepository = clienteRespository;
        this.enderecoRepository = enderecoRepository;
    }

    public Page<Cliente> findAll(Integer page, Integer size){
        Pageable pag = PageRequest.of(page, size, Sort.unsorted());
        return clienteRepository.findAll(pag);
    }

    public Cliente inserir(ClienteRequestDto clienteRequestDto){
        Cliente cliente = clienteRequestDto.toModel();
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente;
    }
}
