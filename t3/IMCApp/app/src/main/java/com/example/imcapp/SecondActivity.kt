package com.example.imcapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imcapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imc = intent.getDoubleExtra("IMC", 0.0)
        val estado = intent.getStringExtra("ESTADO") ?: ""
        val sexo = intent.getStringExtra("SEXO") ?: "H"

        binding.textViewIMC.text = "Tu IMC es: %.2f".format(imc)
        binding.textViewEstado.text = estado

        val imagen = obtenerImagen(estado)
        binding.imageViewEstado.setImageResource(imagen)
    }

    private fun obtenerImagen(estado: String): Int {
        return when (estado) {
            "Bajo peso" -> R.drawable.estado1
            "Peso normal" -> R.drawable.estado2
            "Pre-obesidad" -> R.drawable.estado3
            "Obesidad I" -> R.drawable.estado4
            "Obesidad II" -> R.drawable.estado5
            else -> R.drawable.estado6
        }
    }
}
