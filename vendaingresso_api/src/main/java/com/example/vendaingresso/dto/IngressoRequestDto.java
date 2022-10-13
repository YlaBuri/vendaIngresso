package com.example.vendaingresso.dto;

import com.example.vendaingresso.model.Compra;
import com.example.vendaingresso.model.Evento;
import com.example.vendaingresso.model.Ingresso;
import com.example.vendaingresso.model.Poltrona;
import com.example.vendaingresso.repository.EventoRepository;
import com.example.vendaingresso.repository.PoltronaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IngressoRequestDto {

    private Long id;

    private Double valorIngresso;

    private Compra compra;

    private Long idEvento;

    private List<Long> idPoltronas;

    public Ingresso toModel(EventoRepository eventoRepository, PoltronaRepository poltronaRepository){
        Evento evento = eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Id de evento não encontrado"));
        List<Poltrona> poltronas = new ArrayList<>();
        for (Long id:idPoltronas ) {
            Poltrona poltrona = poltronaRepository.findById(id).orElseThrow(() -> new RuntimeException("Id de poltrona não encontrado"));
            poltronas.add(poltrona);
        }

        return new Ingresso(valorIngresso, compra, evento, poltronas);

    }
}
