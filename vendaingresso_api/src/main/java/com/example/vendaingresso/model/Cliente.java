package com.example.vendaingresso.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    @Column(length = 50)
    private String senha;

    @NotNull
    private Boolean habilitadoReserva;

    @NotBlank
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;

    public Cliente(@NotBlank String nome, @NotBlank String email, @NotBlank String senha, @NotNull Boolean habilitadoReserva, @NotBlank String cpf, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.habilitadoReserva = habilitadoReserva;
        this.cpf = cpf;
        this.endereco = endereco;
    }
}
