package com.example.tiendavirtualandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnCrearCuenta = findViewById<Button>(R.id.btnCrearCuenta)

        val btnLogin = findViewById<Button>(R.id.loginButton)

        btnCrearCuenta.setOnClickListener {
            val intent = Intent(this,RegistrarActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this,ProductListActivity::class.java)
            startActivity(intent)
        }
    }
}