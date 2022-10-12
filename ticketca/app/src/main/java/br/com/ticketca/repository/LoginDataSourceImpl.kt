package br.com.ticketca.repository

class LoginDataSourceImpl: LoginDataSource {
    override suspend fun verifyLogin(username: String, password: String): Boolean {
        return (username == "" && password == "")
    }
}