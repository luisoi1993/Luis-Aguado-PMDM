package com.example.practicachatgpt

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texto = findViewById<TextView>(R.id.tvMensaje)
        val nombreInput = findViewById<EditText>(R.id.etNombre)
        val boton = findViewById<Button>(R.id.btnCambiar)

        boton.setOnClickListener {
            val textoIngresado = nombreInput.text.toString().trim()

            if(textoIngresado.isEmpty()) {
                texto.text = "Hola mundo"
            } else {
                texto.text = "Hola $textoIngresado"
            }

            Toast.makeText(this, "Has pulsado el botón", Toast.LENGTH_SHORT).show()

            texto.setTextColor(Color.WHITE)
            texto.setBackgroundColor(Color.parseColor("#3F51B5"))
        }
    }
}