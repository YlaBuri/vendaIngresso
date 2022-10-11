package com.example.vendaingresso.controller;

import com.example.vendaingresso.model.Endereco;
import com.example.vendaingresso.model.Evento;
import com.example.vendaingresso.service.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    private EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Evento>> listar() {
        List<Evento> eventos = eventoService.findAll();
        return ResponseEntity.ok().body(eventos);
    }


}
