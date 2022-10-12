package br.com.ticketca.repository

import br.com.ticketca.model.Ticket
import br.com.ticketca.ticket.TicketDAO

class TicketDataSourceImpl(
    private val dao: TicketDAO
) : TicketDataSource {
    override suspend fun getTickets(): List<Ticket> {
        return dao.getAllTicket()
    }
}