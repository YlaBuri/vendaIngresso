package br.com.ticketca.repository

import br.com.ticketca.model.Ticket

interface TicketDataSource {

    suspend fun getTickets(): List<Ticket>
}