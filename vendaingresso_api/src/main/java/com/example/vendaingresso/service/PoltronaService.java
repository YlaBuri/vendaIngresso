package com.example.vendaingresso.service;

import com.example.vendaingresso.model.Poltrona;
import com.example.vendaingresso.repository.PoltronaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoltronaService {
    
    private final PoltronaRepository poltronaRepository;

    public PoltronaService(PoltronaRepository poltronaRepository) {
        this.poltronaRepository = poltronaRepository;
    }


    public List<Poltrona> findAll() {
        return poltronaRepository.findAll();
    }

    public List<Poltrona> buscarLivres(Long idEvento) {
        return poltronaRepository.buscarPoltronasLivres(idEvento);
    }
}
