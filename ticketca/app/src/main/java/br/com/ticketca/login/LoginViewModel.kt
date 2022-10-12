package br.com.ticketca.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ticketca.repository.LoginDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val repository: LoginDataSource
) : ViewModel() {
    private val _verifyViewModel = MutableLiveData<Boolean>()
    val verifyViewModel: LiveData<Boolean> get() = _verifyViewModel

    fun verifyLoginUser(username: String, password: String) {
        viewModelScope.launch {
            try {
                val isValid = withContext(Dispatchers.Default) {
                    repository.verifyLogin(username, password)
                }
                withContext(Dispatchers.Main) {
                    _verifyViewModel.value = isValid
                }
            } catch (e: Exception) {
                Log.e("Erro LoginViewModel", e.message.toString())
            }
        }
    }
}