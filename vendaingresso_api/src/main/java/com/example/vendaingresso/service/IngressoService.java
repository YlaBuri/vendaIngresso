package com.example.vendaingresso.service;

import com.example.vendaingresso.model.Ingresso;
import com.example.vendaingresso.repository.IngressoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngressoService {

    private IngressoRepository ingressoRepository;

    public IngressoService(IngressoRepository ingressoRepository) {
        this.ingressoRepository = ingressoRepository;
    }

    public List<Ingresso> findAll() {
        return ingressoRepository.findAll();
    }


}
