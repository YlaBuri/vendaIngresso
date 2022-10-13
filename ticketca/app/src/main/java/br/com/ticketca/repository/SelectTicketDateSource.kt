package br.com.ticketca.repository

import br.com.ticketca.model.Ingresso

interface SelectTicketDateSource {

    suspend fun getSelectTicket(): List<Ingresso>
}