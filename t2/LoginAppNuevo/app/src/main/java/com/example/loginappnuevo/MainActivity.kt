package com.example.loginappnuevo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginappnuevo.databinding.ActivityMainBinding
import com.example.loginappnuevo.model.Usuario
import com.example.loginappnuevo.ui.activity.SecondActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import kotlin.jvm.java

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener,
            MaterialButton.OnCheckedChangeListener{
    lateinit var binding: ActivityMainBinding

    val correo = "luis@gmail.com"

    val contrasenia = "luis" +
            ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.botonLogin.setOnClickListener(this)
        binding.botonGoogle.setOnClickListener(this)
        binding.botonGit.setOnClickListener(this)
        binding.botonFacebook.setOnClickListener(this)
        binding.checkRecordar.setOnClickListener(this)
        binding.spinnerPerfil.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    binding.botonFacebook.visibility = View.INVISIBLE
                    binding.botonGit.visibility = View.INVISIBLE
                    binding.botonGoogle.visibility = View.INVISIBLE

                    when (position) {
                        0 -> binding.botonGoogle.visibility = View.VISIBLE
                        1 -> binding.botonGit.visibility = View.VISIBLE
                        2 -> binding.botonFacebook.visibility = View.VISIBLE
                    }

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }

    }

    override fun onItemSelected(
        p0: AdapterView<*>?,
        p1: View?,
        p2: Int,
        p3: Long
    ) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        when(v?.id){
          binding.botonFacebook.id -> {}
          binding.botonGit.id -> {}
          binding.botonGoogle.id -> {}
          binding.botonLogin.id -> {
              var correoTexto = binding.editCorreo.text

              if(binding.editPass.text.isNotEmpty() && binding.editCorreo.text.isNotEmpty()){
                  if(binding.editPass.text.toString().equals(contrasenia) && binding.editCorreo.text.toString().equals(correo)){
                      val intent = Intent(this, SecondActivity::class.java)
                      val usuario = Usuario(
                          binding.editCorreo.text.toString(),
                          binding.editPass.text.toString(),
                          binding.spinnerPerfil.selectedItem.toString()
                      )
                      intent.putExtra("usuario", usuario)
                      startActivity(intent)
                  }
                  else {
                      Snackbar.make(binding.root, "Correo o contraseña incorrectos", Snackbar.LENGTH_SHORT).show()
                  }

              } else {
                  Snackbar.make(binding.root, "Rellena todos los campos", Snackbar.LENGTH_SHORT).show()
              }
          }
        }

    }

    override fun onCheckedChanged(
        p0: MaterialButton?,
        p1: Boolean )
    {
        binding.botonLogin.isEnabled = p1

    }


}