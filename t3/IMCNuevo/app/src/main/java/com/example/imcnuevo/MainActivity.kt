package com.example.imcnuevo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imcnuevo.databinding.ActivityMainBinding
import com.example.imcnuevo.ui.activity.SecondActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var altura: Double = 0.0
    private var peso: Int = 0
    private var imc: Double = 0.0
    private var sexo: String = ""
    private var resultado: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones();

    }


    private fun acciones() {
        binding.butonCalcular.setOnClickListener(this)


    }

    private fun determinarResultado(imc: Double, sexo: String): String {
       return when (sexo)  {
            "Hombre" -> when {
                imc < 18.5 -> "Bajo peso"
                imc in 18.5..24.9 -> "Peso normal"
                imc in 25.0..29.9 -> "Pre-obesidad o Sobrepeso"
                imc in 30.0..34.9 -> "Obesidad clase I"
                imc in 35.0..39.9 -> "Obesidad clase II"
                else -> "Obesidad clase III"

            }
            "Mujer" -> when {
                imc < 16.5 -> "Bajo peso"
                imc in 16.5..22.9 -> "Peso normal"
                imc in 23.0..25.9 -> "Pre-obesidad o Sobrepeso"
                imc in 26.0..30.9 -> "Obesidad clase I"
                imc in 31.0..33.9 -> "Obesidad clase II"
                else -> "Obesidad clase III"
            }
            else -> ""
        }




    }

    override fun onClick(p0: View?) {
        if (p0 == binding.butonCalcular){
            altura = binding.editTextAltura.text.toString().toDouble()
            peso = binding.editTextPeso.text.toString().toInt()

            sexo = if (binding.radioButtonHombre.isChecked) {
                "Hombre"
            } else if (binding.radioButtonMujer.isChecked) {
                "Mujer"
            }else{
                ""
            }
            if (sexo.isNotEmpty() && altura > 0 && peso > 0) {
                imc = peso / (altura * altura)
               resultado = determinarResultado(imc, sexo)
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("imc", imc)
                intent.putExtra("resultado", resultado)
                startActivity(intent)

            }else{
                Snackbar.make(binding.root, "Rellena todos los campos", Snackbar.LENGTH_SHORT).show()

            }

        }
    }
}