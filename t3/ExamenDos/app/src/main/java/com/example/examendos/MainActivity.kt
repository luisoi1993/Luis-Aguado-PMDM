package com.example.examendos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.examendos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.buttonEnviar.setOnClickListener(this)


        binding.spinnerCombustible.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                actualizarCampos(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        }



    private fun actualizarCampos(posicion: Int) {
        val combustible = binding.spinnerCombustible.selectedItem.toString()

        if (combustible == "Híbrido") {
            binding.editTextAutonomia.isEnabled = true
            binding.editTextAnyo.isEnabled = false
            binding.editTextAnyo.setText("2018")
        } else if (combustible == "Eléctrico") {
            binding.editTextAutonomia.isEnabled = false
            binding.editTextAutonomia.setText("")
            binding.editTextAnyo.isEnabled = false
            binding.editTextAnyo.setText("2018")
        } else {
            binding.editTextAutonomia.isEnabled = false
            binding.editTextAutonomia.setText("")
            binding.editTextAnyo.isEnabled = true
            binding.editTextAnyo.setText("")
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == binding.buttonEnviar.id) {
            enviarDatos()
        }
    }

    private fun enviarDatos() {

        if (binding.editTextPropietario.text.isNullOrEmpty()) {
            Snackbar.make(binding.root, "Introduce el propietario", Snackbar.LENGTH_LONG).show()
            return
        }

        if (binding.editTextMatricula.text.isNullOrEmpty()) {
            Snackbar.make(binding.root, "Introduce la matrícula", Snackbar.LENGTH_LONG).show()
            return
        }

        val combustible = binding.spinnerCombustible.selectedItem.toString()

        if (binding.editTextAnyo.text.isNullOrEmpty()) {
            Snackbar.make(binding.root, "Introduce el año", Snackbar.LENGTH_LONG).show()
            return
        }

        val propietario = binding.editTextPropietario.text.toString()
        val matricula = binding.editTextMatricula.text.toString()
        val anyo = binding.editTextAnyo.text.toString().toInt()
        val autonomia = if (binding.editTextAutonomia.text.isNullOrEmpty()) 0
        else binding.editTextAutonomia.text.toString().toInt()

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("PROPIETARIO", propietario)
        intent.putExtra("MATRICULA", matricula)
        intent.putExtra("ANYO", anyo)
        intent.putExtra("COMBUSTIBLE", combustible)
        intent.putExtra("AUTONOMIA", autonomia)
        startActivity(intent)
    }
}

