package br.com.ticketca.ticket

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ticketca.model.Ticket
import br.com.ticketca.repository.TicketDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TicketViewModel(
    private val repository: TicketDataSource
) : ViewModel() {

    private val _ticketViewModel = MutableLiveData<List<Ticket>>()
    val ticketViewModel: LiveData<List<Ticket>> get() = _ticketViewModel

    fun findTickets() {
        viewModelScope.launch {
            try {
                val news = withContext(Dispatchers.Default) {
                    repository.getTickets()
                }
                withContext(Dispatchers.Main) {
                    _ticketViewModel.value = news
                }
            } catch (e: Exception) {
                Log.e("Erro News", e.message.toString())
            }
        }
    }
}