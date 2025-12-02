package com.example.examendos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examendos.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mostrarDatos()
    }

    private fun mostrarDatos() {
        val propietario = intent.getStringExtra("PROPIETARIO") ?: ""
        val matricula = intent.getStringExtra("MATRICULA") ?: ""
        val anyo = intent.getIntExtra("ANYO", 0)
        val combustible = intent.getStringExtra("COMBUSTIBLE") ?: ""
        val autonomia = intent.getIntExtra("AUTONOMIA", 0)

        binding.textViewPropietario.text = "Propietario: $propietario"
        binding.textViewMatricula.text = "Matrícula: $matricula"
        binding.textViewDatos.text = "Año: $anyo\nCombustible: $combustible\nAutonomía: $autonomia km"

        val etiqueta = obtenerEtiqueta(combustible, anyo, autonomia)
        binding.imageViewEtiqueta.setImageResource(etiqueta)
    }

    private fun obtenerEtiqueta(combustible: String, anyo: Int, autonomia: Int): Int {

        return when {
            combustible == "Eléctrico" -> R.drawable.etiqueta0
            combustible == "Híbrido" && autonomia > 80 -> R.drawable.etiqueta0
            combustible == "Híbrido" -> R.drawable.etiquetaecko
            combustible == "Diésel" && anyo in 2006..2015 -> R.drawable.etiquetac
            combustible == "Gasolina" && anyo in 2008..2017 -> R.drawable.etiquetac
            else -> R.drawable.etiquetab
        }
    }
}
