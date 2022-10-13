package com.example.vendaingresso.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    @JsonBackReference(value="cliente-endereco")
    private Endereco endereco;

    @Valid
    @NotNull
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL, mappedBy = "cliente")
    @JsonManagedReference
    private List<Compra> compras;

    public Cliente(@NotBlank String nome, @NotBlank String email, @NotBlank String senha, @NotNull Boolean habilitadoReserva, @NotBlank String cpf, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.habilitadoReserva = habilitadoReserva;
        this.cpf = cpf;
        this.endereco = endereco;
    }
}
