package com.example.imcnuevo.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imcnuevo.R
import com.example.imcnuevo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        intent.extras?.let { bundle ->
            val imc = bundle.getDouble("imc")
            val resultado = bundle.getString("resultado")
            binding.textViewImcCalculo.text = imc.toString()
            binding.textViewImc.text = resultado
            binding.imageView.setImageResource(determinarImagen(resultado!!))
        }


    }

    private fun determinarImagen(resultado: String): Int {
        return when (resultado) {
            "Bajo peso" -> R.drawable.estado1
            "Peso normal"-> R.drawable.estado2
            "Pre-obesidad o Sobrepeso" -> R.drawable.estado3
            "Obesidad clase I" -> R.drawable.estado4
            "Obesidad clase II" -> R.drawable.estado5
            "Obesidad clase III" -> R.drawable.estado6
            else -> R.drawable.estado1
        }

    }

}