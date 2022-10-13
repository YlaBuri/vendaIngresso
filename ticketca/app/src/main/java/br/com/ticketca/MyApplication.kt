package br.com.ticketca

import android.app.Application
import br.com.ticketca.di.loginModule
import br.com.ticketca.di.selectTicketModule
import br.com.ticketca.di.ticketModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class MyApplication: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(loginModule, ticketModule, selectTicketModule)
        }
    }
}