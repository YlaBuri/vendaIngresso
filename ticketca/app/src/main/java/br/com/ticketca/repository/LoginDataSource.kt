package br.com.ticketca.repository

interface LoginDataSource {
    suspend fun verifyLogin(username: String, password: String): Boolean
}