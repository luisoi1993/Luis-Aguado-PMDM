package com.example.vuelos

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.vuelos.databinding.ActivityMainBinding
import com.example.vuelos.dataset.Dataset
import com.example.vuelos.ui.activities.HomeActivity
import com.example.vuelos.ui.activities.RegistroActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.buttonLogin.setOnClickListener(this)
        binding.buttonRegister.setOnClickListener(this)
    }



    override fun onClick(p0: View?) {
        if (p0 == binding.buttonRegister) {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)

        } else if (p0 == binding.buttonLogin) {
           //comprobar que el correo y la contraseña sean correctos
            if (Dataset.comprobarLogin(binding.editTextCorreo.text.toString(), binding.editTextPassword.text.toString())) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Snackbar.make(binding.root, "Correo o contraseña incorrectos", Snackbar.LENGTH_SHORT).show()
                binding.editTextCorreo.text.clear()
                binding.editTextPassword.text.clear()


            }
        }

    }
}