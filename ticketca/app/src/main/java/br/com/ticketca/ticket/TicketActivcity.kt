package br.com.ticketca.ticket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.ticketca.R
import br.com.ticketca.model.Ticket
import br.com.ticketca.register.RegisterActivity
import br.com.ticketca.step.SelectDateActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TicketActivcity : AppCompatActivity() {

    private val ticketViewModel: TicketViewModel by viewModel()
    private lateinit var adapter: TicketAdapter

    private val tickerRecicleView: RecyclerView by lazy {
        findViewById(R.id.activity_ticket_recycler_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        configureAdapter()


    }

    private fun configureAdapter() {
        ticketViewModel.ticketViewModel.observe(this, { it ->
            adapter = TicketAdapter(it)
            tickerRecicleView.adapter = adapter
            tickerRecicleView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter.onItemClickListener = {
                val intent = Intent(this, SelectDateActivity::class.java)
                intent.putExtra("ticket", it.titulo)
                startActivity(intent)
            }
        })

        ticketViewModel.findTickets()
    }
}