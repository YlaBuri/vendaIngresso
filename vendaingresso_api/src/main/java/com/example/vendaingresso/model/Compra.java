package com.example.vendaingresso.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Long id;

    @NotNull
    @Column(name = "data_compra")
    private LocalDateTime dataCompra;

    @Column(name = "reserva")
    private boolean reserva;

    @Column(name = "entrega_domicilio")
    private boolean entregaDomicilio;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingresso_id", referencedColumnName = "ingresso_id")
    private Ingresso ingresso;
}
