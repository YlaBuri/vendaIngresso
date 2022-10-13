package br.com.ticketca.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.ticketca.R
import br.com.ticketca.home.HomeActivity
import br.com.ticketca.register.RegisterActivity
import br.com.ticketca.ticket.TicketActivcity
import com.google.android.material.textfield.TextInputEditText
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.button)
        val username = findViewById<TextInputEditText>(R.id.activity_login_username)
        val password = findViewById<TextInputEditText>(R.id.activity_login_password)
        val btnRegister = findViewById<Button>(R.id.button_login_register)

        loginViewModel.verifyViewModel.observe(this, Observer {
            if (it) {
                nextScreen()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Login Failed")
                builder.setMessage("Usuário ou senha inválidos")
                builder.setPositiveButton("OK") { _, _ -> }
                val alert = builder.create()
                alert.show()
            }
        })

        btnLogin.setOnClickListener {
            loginViewModel.verifyLoginUser(username.text.toString(), password.text.toString())
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun nextScreen() {
        val intent = Intent(this, TicketActivcity::class.java)
        startActivity(intent)
        finish()

    }
}