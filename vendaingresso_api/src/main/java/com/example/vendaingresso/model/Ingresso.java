package com.example.vendaingresso.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingresso_id")
    private Long id;

    @Column(name = "valor_ingresso")
    private Double valorIngresso;

    @OneToOne(mappedBy = "ingresso")
    @JsonBackReference
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ingresso_poltrona",
            joinColumns = @JoinColumn(name = "ingresso_id"),
            inverseJoinColumns = @JoinColumn(name = "poltrona_id")
    )
    private List<Poltrona> poltronas;
}
