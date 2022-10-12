package br.com.ticketca.model

import java.io.Serializable

data class Ticket(
    val titulo: String,
    val imagem: String
) : Serializable