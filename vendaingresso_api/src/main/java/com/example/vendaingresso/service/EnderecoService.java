package com.example.vendaingresso.service;

import com.example.vendaingresso.model.Endereco;
import com.example.vendaingresso.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository =  enderecoRepository;
    }

    public List<Endereco> findAll() {
        return this.enderecoRepository.findAll();
    }
}
