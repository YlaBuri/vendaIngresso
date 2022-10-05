package com.example.vendaingresso.dto;

import com.example.vendaingresso.model.Cliente;
import com.example.vendaingresso.model.Compra;
import com.example.vendaingresso.model.Ingresso;
import com.example.vendaingresso.repository.ClienteRespository;
import com.example.vendaingresso.repository.EventoRepository;
import com.example.vendaingresso.repository.PoltronaRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CompraRequestDto {

    private LocalDateTime dataCompra;

    private boolean reserva;

    private boolean entregaDomicilio;

    private Long idCliente;

    private IngressoRequestDto ingresso;

    public Compra toModel(ClienteRespository clienteRespository, EventoRepository eventoRepository, PoltronaRepository poltronaRepository) {
        Cliente cliente =  clienteRespository.findById(idCliente).orElseThrow(() -> new RuntimeException("Id de cliente não encontrado"));
        return new Compra(dataCompra, reserva, entregaDomicilio, cliente, ingresso.toModel(eventoRepository,poltronaRepository));
    }
}
