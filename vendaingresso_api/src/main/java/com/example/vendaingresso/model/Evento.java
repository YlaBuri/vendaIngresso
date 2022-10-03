package com.example.vendaingresso.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Column(name = "data_evento")
    private LocalDateTime dataEvento;

    @Valid
    @NotNull
    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "evento")
    @JsonBackReference
    private List<Ingresso> ingressos;

    @ManyToMany(mappedBy = "eventos")
    @JsonBackReference
    private List<Poltrona> poltronasOculpadas;
}
