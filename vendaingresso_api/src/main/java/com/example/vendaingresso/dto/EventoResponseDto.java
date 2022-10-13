package com.example.vendaingresso.dto;

import com.example.vendaingresso.model.Evento;
import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class EventoResponseDto {

    private Long id;
    private String nome;
    private LocalDateTime dataEvento;

    public EventoResponseDto(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.dataEvento = evento.getDataEvento();
    }
}
