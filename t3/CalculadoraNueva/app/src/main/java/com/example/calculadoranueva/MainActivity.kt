package com.example.calculadoranueva

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoranueva.databinding.ActivityMainBinding

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
            binding.buttonUno,
            binding.buttonDos,
            binding.buttonTres,
            binding.buttonCuatro,
            binding.buttonCinco,
            binding.buttonSeis,
            binding.buttonSiete,
            binding.buttonOcho,
            binding.buttonNueve,
            binding.buttonCero,
            binding.buttonSumar,
            binding.buttonRestar,
            binding.buttonMultiplicar,
            binding.buttonDividir,
            binding.buttonPunto,
            binding.buttonIgual,
            binding.buttonBorrar,
            binding.buttonNegativo,
            binding.buttonRaiz,
            binding.buttonCuadrado,
            binding.buttonPotencia
        )
        botones.forEach {
            it?.setOnClickListener(this)
        }

    }

    override fun onClick(p0: View?) {
        val boton = p0 as? android.widget.Button ?: return
        val id = boton.id

        when (id) {
            binding.buttonCero.id,
            binding.buttonUno.id,
            binding.buttonDos.id,
            binding.buttonTres.id,
            binding.buttonCuatro.id,
            binding.buttonCinco.id,
            binding.buttonSeis.id,
            binding.buttonSiete.id,
            binding.buttonOcho.id,
            binding.buttonNueve.id,
            binding.buttonPunto.id -> {
                numeroPresionado(boton.text.toString())

            }



            binding.buttonSumar.id -> operadorPresionado("+")
            binding.buttonRestar.id -> operadorPresionado("-")
            binding.buttonMultiplicar.id -> operadorPresionado("*")
            binding.buttonDividir.id -> operadorPresionado("/")
            binding.buttonPotencia?.id -> operadorPresionado("^")
            binding.buttonRaiz?.id -> operadorPresionado("√")
            binding.buttonCuadrado?.id -> operadorPresionado("x²")
            binding.buttonNegativo?.id -> operadorPresionado("1/x")


            binding.buttonIgual.id -> calcularResultado()

            binding.buttonBorrar.id -> limpiarTodo()


        }
    }

    private fun numeroPresionado(valor: String){
        if (nuevoCalculo){
            binding.textViewResultado.text = ""
            nuevoCalculo = false
        }

        val textoActual = binding.textViewResultado.text.toString()

        if (valor == "." && textoActual.contains(".")){
            return
        }

        binding.textViewResultado.text = textoActual + valor

    }

    private fun operadorPresionado(operador: String){
        try {
            primerNumero = binding.textViewResultado.text.toString().toDouble()
            operadorActual = operador


            if (operador == "√" || operador == "x²" || operador == "^"){
                calcularResultado()
            } else{
                nuevoCalculo = true
            }



        }catch (e: NumberFormatException){
            binding.textViewResultado.text = "Error"
        }

    }

    private fun calcularResultado(){
        try {
            if(primerNumero == null || operadorActual == null) return

            val resultado = when(operadorActual){

                "+", "-", "*", "/" -> {
                    segundoNumero = binding.textViewResultado.text.toString().toDouble()


                    when(operadorActual){

                        "+" -> primerNumero!! + segundoNumero!!
                        "-" -> primerNumero!! - segundoNumero!!
                        "*" -> primerNumero!! * segundoNumero!!
                        "/" -> if(segundoNumero!! != 0.0) primerNumero!! / segundoNumero!! else Double.NaN
                        "^" -> Math.pow(primerNumero!!, segundoNumero!!)
                        else -> 0.0

                    }
                }
                "√" -> Math.sqrt(primerNumero!!)
                "x²" -> Math.pow(primerNumero!!, 2.0)
                "1/x" -> if(primerNumero != 0.0) 1 / primerNumero!! else Double.NaN

                else -> 0.0
            }

            binding.textViewResultado.text =
                if (resultado.isNaN()) "Error" else resultado.toString()

            primerNumero = resultado
            nuevoCalculo = true

        }catch (e: NumberFormatException){
            binding.textViewResultado.text = "Error"
        }
    }

    private fun limpiarTodo(){
        primerNumero = null
        segundoNumero = null
        operadorActual = null
        nuevoCalculo = false
        binding.textViewResultado.text = "0"
    }
}