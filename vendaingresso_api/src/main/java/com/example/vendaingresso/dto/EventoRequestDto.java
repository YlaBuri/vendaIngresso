package com.example.vendaingresso.dto;

import com.example.vendaingresso.model.Evento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EventoRequestDto {
    private String nome;
    private LocalDateTime dataEvento;

    public Evento toModel() {
        return new Evento(nome, dataEvento);
    }
}
