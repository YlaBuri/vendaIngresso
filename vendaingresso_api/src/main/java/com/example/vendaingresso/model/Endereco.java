package com.example.vendaingresso.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long id;

    @NotBlank
    @Column(length = 50)
    private String estado;

    @NotBlank
    @Column(length = 50)
    private String cidade;

    @NotBlank
    @Column(length = 50)
    private String cep;

    @NotBlank
    @Column(length = 5)
    private String numero;

    @OneToOne(mappedBy = "endereco")
    @JsonBackReference
    private Cliente cliente;
}
