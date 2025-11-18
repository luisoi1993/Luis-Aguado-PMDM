package com.example.imcapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.imcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.buttonCalcular.id -> calcular()
        }
    }

    private fun calcular() {


        if (binding.editTextAltura.text.isNullOrEmpty()) {
            Snackbar.make(binding.root, "Introduce la altura", Snackbar.LENGTH_LONG).show()
            return
        }


        if (binding.editTextPeso.text.isNullOrEmpty()) {
            Snackbar.make(binding.root, "Introduce el peso", Snackbar.LENGTH_LONG).show()
            return
        }


        val selectedId = binding.radioGroupSexo.checkedRadioButtonId
        if (selectedId == -1) {
            Snackbar.make(binding.root, "Selecciona el sexo", Snackbar.LENGTH_LONG).show()
            return
        }


        val altura = binding.editTextAltura.text.toString().toDouble()
        val peso = binding.editTextPeso.text.toString().toDouble()
        val imc = peso / (altura * altura)

        val sexo =
            if (selectedId == binding.radioHombre.id) "H"
            else "M"

        val estado = obtenerEstadoIMC(imc, sexo)


        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("IMC", imc)
        intent.putExtra("ESTADO", estado)
        intent.putExtra("SEXO", sexo)
        startActivity(intent)
    }

    private fun obtenerEstadoIMC(imc: Double, sexo: String): String {
        return if (sexo == "H") {
            when {
                imc < 18.5 -> "Bajo peso"
                imc < 24.9 -> "Peso normal"
                imc < 29.9 -> "Pre-obesidad"
                imc < 34.9 -> "Obesidad I"
                imc < 39.9 -> "Obesidad II"
                else -> "Obesidad III"
            }
        } else {
            when {
                imc < 16.5 -> "Bajo peso"
                imc < 22.9 -> "Peso normal"
                imc < 25.9 -> "Pre-obesidad"
                imc < 30.9 -> "Obesidad I"
                imc < 33.9 -> "Obesidad II"
                else -> "Obesidad III"
            }
        }
    }
}
