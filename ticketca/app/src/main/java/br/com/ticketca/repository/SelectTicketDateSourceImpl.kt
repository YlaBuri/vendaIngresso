package br.com.ticketca.repository

import br.com.ticketca.model.Ingresso
import br.com.ticketca.model.IngressosDAO

class SelectTicketDateSourceImpl(
    private val dao: IngressosDAO
): SelectTicketDateSource {
    override suspend fun getSelectTicket(): List<Ingresso> {
        return dao.getSelectTicket()
    }

}