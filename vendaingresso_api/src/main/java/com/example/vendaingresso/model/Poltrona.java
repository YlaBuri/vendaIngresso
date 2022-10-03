package com.example.vendaingresso.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Poltrona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poltrona_id")
    private Long id;

    @NotBlank
    private String localizacao;

    private Double valor;

    @ManyToMany(mappedBy = "poltronas")
    private List<Ingresso> ingressos;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "evento_poltrona",
            joinColumns = @JoinColumn(name = "poltrona_id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventos;

}
