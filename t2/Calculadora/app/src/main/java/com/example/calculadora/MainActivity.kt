package com.example.calculadora

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    private var operadorActual: String? = null
    private var primerNumero: Double? = null
    private var segundoNumero: Double? = null
    private var nuevoCalculo = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()

    }

    private fun acciones() {

        val botones = listOf(
            binding.boton0, binding.boton1, binding.boton2, binding.boton3, binding.boton4,
            binding.boton5, binding.boton6, binding.boton7, binding.boton8, binding.boton9,
            binding.botonMas, binding.botonMenos, binding.botonMultiplicar, binding.botonDividir,
            binding.botonPunto, binding.botonIgual, binding.botonC, binding.botonPotencia,
            binding.botonRaiz, binding.botonCuadrado, binding.botonNegativo
        )

        botones.forEach { it?.setOnClickListener(this) }

    }

    override fun onClick(view: View?) {
        val boton = view as? android.widget.Button ?: return
        val id = boton.id

        when (id) {

            binding.boton0.id,
            binding.boton1.id,
            binding.boton2.id,
            binding.boton3.id,
            binding.boton4.id,
            binding.boton5.id,
            binding.boton6.id,
            binding.boton7.id,
            binding.boton8.id,
            binding.boton9.id,
            binding.botonPunto.id -> {
                numeroPresionado(boton.text.toString())
            }

            binding.botonMas.id -> operadorPresionado("+")
            binding.botonMenos.id -> operadorPresionado("-")
            binding.botonMultiplicar.id -> operadorPresionado("*")
            binding.botonDividir.id -> operadorPresionado("/")
            binding.botonPotencia?.id -> operadorPresionado("^")
            binding.botonRaiz?.id -> operadorPresionado("√")
            binding.botonCuadrado?.id -> operadorPresionado("x²")
            binding.botonNegativo?.id -> operadorPresionado("1/x")

            binding.botonIgual.id -> calcularResultado()

            binding.botonC.id -> limpiarTodo()
        }
    }

    private fun numeroPresionado(valor: String) {
        if (nuevoCalculo) {
            binding.textViewRegistro.text = ""
            nuevoCalculo = false
        }

        val textoActual = binding.textViewRegistro.text.toString()

        if (valor == "." && textoActual.contains(".")) return

        binding.textViewRegistro.text = textoActual + valor
    }

    private fun operadorPresionado(operador: String) {
        try {
            primerNumero = binding.textViewRegistro.text.toString().toDouble()
            operadorActual = operador


            if (operador == "√" || operador == "x²" || operador == "1/x") {
                calcularResultado()
            } else {
                nuevoCalculo = true
            }

        } catch (e: NumberFormatException) {
            binding.textViewRegistro.text = "Error"
        }
    }

    private fun calcularResultado() {
        try {

            if (primerNumero == null || operadorActual == null) return

            val resultado = when (operadorActual) {


                "+", "-", "*", "/", "^" -> {
                    segundoNumero = binding.textViewRegistro.text.toString().toDouble()

                    when (operadorActual) {
                        "+" -> primerNumero!! + segundoNumero!!
                        "-" -> primerNumero!! - segundoNumero!!
                        "*" -> primerNumero!! * segundoNumero!!
                        "/" -> if (segundoNumero != 0.0) primerNumero!! / segundoNumero!! else Double.NaN
                        "^" -> Math.pow(primerNumero!!, segundoNumero!!)
                        else -> 0.0
                    }
                }


                "√" -> Math.sqrt(primerNumero!!)
                "x²" -> primerNumero!! * primerNumero!!
                "1/x" -> if (primerNumero != 0.0) 1 / primerNumero!! else Double.NaN

                else -> 0.0
            }

            binding.textViewRegistro.text =
                if (resultado.isNaN()) "Error" else resultado.toString()

            primerNumero = resultado
            nuevoCalculo = true

        } catch (e: NumberFormatException) {
            binding.textViewRegistro.text = "Error"
        }
    }

    private fun limpiarTodo() {
        binding.textViewRegistro.text = "0"
        primerNumero = null
        segundoNumero = null
        operadorActual = null
        nuevoCalculo = false
    }
}
