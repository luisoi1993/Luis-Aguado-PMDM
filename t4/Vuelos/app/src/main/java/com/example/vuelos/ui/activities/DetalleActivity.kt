package com.example.vuelos.ui.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vuelos.R
import com.example.vuelos.databinding.ActivityDetalleBinding
import com.example.vuelos.model.Vuelo

class DetalleActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initGUI()
        acciones()
    }

    private fun acciones() {
        binding.buttonVolver.setOnClickListener(this)

    }

    private fun initGUI() {
        val vuelo = intent.getSerializableExtra("vuelo") as Vuelo
        binding.textCiudadOrigen.text = vuelo.origen
        binding.textCiudadDestino.text = vuelo.destino
        binding.textFecha.text = vuelo.fecha
        binding.textHora.text = vuelo.hora
        binding.textPrecio.text = vuelo.precio.toString()
        binding.textAsientos.text = vuelo.asientos.toString()

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttonVolver -> {
                finish()
            }
        }
    }

}