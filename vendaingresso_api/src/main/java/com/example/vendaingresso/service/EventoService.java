package com.example.vendaingresso.service;

import com.example.vendaingresso.dto.EventoRequestDto;
import com.example.vendaingresso.model.Evento;
import com.example.vendaingresso.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> findAll() {
        return eventoRepository.findAllByOrderByDataEventoDesc();
    }

    public Evento inserir(EventoRequestDto eventoRequestDto) {
        Evento evento = eventoRequestDto.toModel();
        return eventoRepository.save(evento);
    }
}
