package com.example.vuelos.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.vuelos.MainActivity
import com.example.vuelos.databinding.ActivityRegistroBinding
import com.example.vuelos.dataset.Dataset
import com.example.vuelos.model.Favoritos
import com.example.vuelos.model.Usuario
import com.example.vuelos.model.Vuelo

class RegistroActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.buttonRegistrar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == binding.buttonRegistrar) {
           if (binding.editTextNombre.text.toString().isNotEmpty() && binding.editTextCorreo.text.toString().isNotEmpty()
               && binding.editTextPassword.text.toString().isNotEmpty() && binding.spinnerPerfil.selectedItem.toString().isNotEmpty()
               && binding.editTextEdad.text.toString().isNotEmpty()){
               val nombre = binding.editTextNombre.text.toString()
               val correo = binding.editTextCorreo.text.toString()
               val contraseña = binding.editTextPassword.text.toString()
               val perfil = binding.spinnerPerfil.selectedItem.toString()
               val edad = binding.editTextEdad.text.toString().toInt()
               val vuelos = ArrayList<Vuelo>()
               val favoritos = ArrayList<Favoritos>()
               //comprobar que no haya ningun usuario con el mismo correo
               if (!Dataset.comprobarCorreo(correo)) {
                   binding.editTextCorreo.error = "Correo ya registrado"
                   return
               }
               val usuario = Usuario(nombre, correo, contraseña, perfil, edad, vuelos, favoritos)
               Dataset.agregarUsuario(usuario)
               val intent = Intent(this, MainActivity::class.java)
               startActivity(intent)
               limpiarCampos()

           }else {
               binding.editTextNombre.error = "Campo obligatorio"
               binding.editTextCorreo.error = "Campo obligatorio"
               binding.editTextPassword.error = "Campo obligatorio"
               binding.editTextEdad.error = "Campo obligatorio"

           }
        }

    }

    private fun limpiarCampos() {
        binding.editTextNombre.text.clear()
        binding.editTextCorreo.text.clear()
        binding.editTextPassword.text.clear()
        binding.editTextEdad.text.clear()

    }
}