package br.com.ticketca.model

data class Evento(
    val nome: String,
    val ingressos: List<Ingresso>
)


data class Ingresso(
    val valorIngresso: Double,
    val compra: Compra
)

data class Compra(
    val id: Long
)