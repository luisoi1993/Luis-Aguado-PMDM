package com.example.adivinacioncartas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adivinacioncartas.databinding.ActivityMainBinding
import com.example.adivinacioncartas.ui.activity.SecondActivity
import com.google.android.material.snackbar.Snackbar
import kotlin.jvm.java

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()

    }

    private fun acciones() {
        binding.botonEmpezar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        if(binding.editTextNombre.text.isEmpty()){
            Snackbar.make(binding.root, "Por favor introduce nombre", Snackbar.LENGTH_SHORT).show()
        } else {
            val nombre = binding.editTextNombre.text.toString()
            val snackbar = Snackbar.make(binding.root, "Perfecto $nombre , quieres empezar", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("ok"){
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("nombre", nombre)
                startActivity(intent)
            }
            snackbar.show()

        }
    }
}