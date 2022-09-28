package com.example.vendaingresso.dto;


import com.example.vendaingresso.model.Cliente;
import com.example.vendaingresso.model.Endereco;
import lombok.Getter;


@Getter
public class ClienteResponseDto {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private Boolean habilitadoReserva;

    private String cpf;

    private Endereco endereco;

    public ClienteResponseDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.habilitadoReserva = cliente.getHabilitadoReserva();
        this.cpf = cliente.getCpf();
        this.endereco = cliente.getEndereco();
    }
}
