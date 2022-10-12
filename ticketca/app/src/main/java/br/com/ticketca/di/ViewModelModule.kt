package br.com.ticketca.di

import br.com.ticketca.login.LoginViewModel
import br.com.ticketca.repository.LoginDataSource
import br.com.ticketca.repository.LoginDataSourceImpl
import br.com.ticketca.repository.TicketDataSource
import br.com.ticketca.repository.TicketDataSourceImpl
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