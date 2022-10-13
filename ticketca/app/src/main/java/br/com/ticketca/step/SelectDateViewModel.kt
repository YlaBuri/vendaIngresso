package br.com.ticketca.step

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ticketca.model.Ingresso
import br.com.ticketca.repository.SelectTicketDateSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SelectDateViewModel(
    private val repository: SelectTicketDateSource
) : ViewModel() {
    private val _selectTicketDate = MutableLiveData<List<Ingresso>>()
    val selectTicketDate: LiveData<List<Ingresso>> get() = _selectTicketDate

    fun findSelectTicketDate() {
        viewModelScope.launch {
            try {
                val selectTicket = withContext(Dispatchers.Default) {

                    repository.getSelectTicket()
                }
                withContext(Dispatchers.Main) {
                    _selectTicketDate.value = selectTicket
                }
            } catch (e: Exception) {
                Log.e("Erro SelectTicket", e.message.toString())
            }
        }
    }
}