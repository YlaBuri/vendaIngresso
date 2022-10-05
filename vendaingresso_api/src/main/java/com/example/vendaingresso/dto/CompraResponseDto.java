package com.example.vendaingresso.dto;

import com.example.vendaingresso.model.Compra;
import com.example.vendaingresso.model.Ingresso;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CompraResponseDto {
    private Long id;

    private LocalDateTime dataCompra;

    private boolean reserva;

    private boolean entregaDomicilio;

    private Long idCliente;

    private Ingresso ingresso;

    public CompraResponseDto(Compra compra) {
        this.id = compra.getId();
        this.dataCompra = compra.getDataCompra();
        this.reserva = compra.isReserva();
        this.entregaDomicilio = compra.isEntregaDomicilio();
        this.idCliente = compra.getCliente().getId();
        this.ingresso = compra.getIngresso();
    }
}
