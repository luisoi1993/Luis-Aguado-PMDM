package com.example.holamundonuevo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.holamundonuevo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()

    }

    private fun acciones() {

        binding.botonSaludar.setOnClickListener {
            var snackbar = Snackbar.make(
                it,
                "Saludo: " + resources.getString(R.string.saludo_snack),
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction("Ocultar") {
                snackbar.dismiss()
            }
            snackbar.show()
            }
        }
    }
