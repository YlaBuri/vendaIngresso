package com.example.vendaingresso.dto;


import com.example.vendaingresso.model.Cliente;
import com.example.vendaingresso.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClienteRequestDto {

    private String nome;

    private String email;

    private String senha;

    private Boolean habilitadoReserva;

    private String cpf;

    private Endereco endereco;

    public Cliente toModel() {
        return new Cliente(nome, email, senha, habilitadoReserva, cpf, endereco);
    }
}
