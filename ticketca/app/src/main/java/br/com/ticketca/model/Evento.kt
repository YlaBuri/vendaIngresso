package br.com.ticketca.model

import java.io.Serializable

data class Evento(
    val nome: String,
    val ingressos: List<Ingresso>
): Serializable


data class Ingresso(
    val referencia: String,
    val valorIngresso: Double
): Serializable

data class Compra(
    val id: Long
): Serializable