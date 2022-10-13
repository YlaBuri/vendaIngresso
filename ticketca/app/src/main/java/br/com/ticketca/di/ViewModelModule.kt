package br.com.ticketca.di

import br.com.ticketca.login.LoginViewModel
import br.com.ticketca.model.IngressosDAO
import br.com.ticketca.repository.*
import br.com.ticketca.step.SelectDateViewModel
import br.com.ticketca.ticket.TicketDAO
import br.com.ticketca.ticket.TicketViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    factory<LoginDataSource> {
        LoginDataSourceImpl()
    }

    viewModel{
        LoginViewModel(get())
    }
}

val ticketModule = module {

    factory {
        TicketDAO()
    }

    factory<TicketDataSource> {
        TicketDataSourceImpl(get())
    }

    viewModel {
        TicketViewModel(get())
    }
}

val selectTicketModule = module {

    factory {
        IngressosDAO()
    }

    factory<SelectTicketDateSource> {
        SelectTicketDateSourceImpl(get())
    }

    viewModel {
        SelectDateViewModel(get())
    }
}