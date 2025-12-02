package com.example.loginappnuevo.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginappnuevo.R
import com.example.loginappnuevo.databinding.ActivitySecondBinding
import com.example.loginappnuevo.model.Usuario

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuario = intent.getSerializableExtra("usuario") as Usuario
        binding.textoSaludo.text = "Bienvenido ${usuario?.correo}"
        binding.textoPlataforma.text = "Plataforma: ${usuario?.plataforma}"
    }
}