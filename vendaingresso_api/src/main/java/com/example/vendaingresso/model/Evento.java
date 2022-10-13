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


    @Column(name = "data_evento")
    private LocalDateTime dataEvento;

    @Valid
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    @JsonManagedReference
    private List<Ingresso> ingressos;

//    @ManyToMany(mappedBy = "eventos")
//    @JsonBackReference(value = "eventos-poltrona")
//    private List<Poltrona> poltronasOculpadas;

    public Evento(String nome, LocalDateTime dataEvento) {
        this.nome = nome;
        this.dataEvento = dataEvento;
    }
}
