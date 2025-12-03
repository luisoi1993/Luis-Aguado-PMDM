package com.example.examendgt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examendgt.databinding.ActivityMainBinding
import com.example.examendgt.ui.SecondActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
        initGUI()
    }

    private fun initGUI() {
        binding.editTextAutonomia.isEnabled = false
    }

    private fun acciones() {
        binding.buttonEnviar.setOnClickListener(this)

        /*Si se selecciona híbrido o eléctrico en el tipo de combustible, el año de
matriculación se desactivará y se pondrá por defecto 2018. En
cualquier otro caso se activará y se podrá introducir
o Si se selecciona híbrido se activa el campo autonomía. En cualquier
otro caso se desactiva.
o En caso de pulsar el botón y faltar datos por rellenar saltará un
snackbar con el aviso.  */
        binding.spinnerGasolina.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val seleccionado = binding.spinnerGasolina.selectedItem.toString()
                when (seleccionado) {
                    "Hibrido" -> {
                        binding.editTextAnioMatriculacion.isEnabled = false
                        binding.editTextAnioMatriculacion.setText("2018")
                        binding.editTextAutonomia.isEnabled = true
                        binding.imageViewSpinner.setImageResource(R.drawable.hibrido)

                    }
                    "Electrico" -> {
                        binding.editTextAnioMatriculacion.isEnabled = false
                        binding.editTextAnioMatriculacion.setText("2018")
                        binding.editTextAutonomia.isEnabled = false
                        binding.imageViewSpinner.setImageResource(R.drawable.electrico)
                    }

                    "Diesel" -> {
                        binding.editTextAnioMatriculacion.isEnabled = true
                        binding.editTextAutonomia.isEnabled = false
                        binding.imageViewSpinner.setImageResource(R.drawable.diesel)
                        binding.editTextAnioMatriculacion.setText("")
                    }

                    "Gasolina" -> {
                        binding.editTextAnioMatriculacion.isEnabled = true
                        binding.editTextAutonomia.isEnabled = false
                        binding.imageViewSpinner.setImageResource(R.drawable.gasolina)
                        binding.editTextAnioMatriculacion.setText("")
                    }

                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    override fun onClick(p0: View?) {
        if (p0 == binding.buttonEnviar){

            if(binding.editTextNombre.text.isEmpty() || binding.editTextMatricula.text.isEmpty() || binding.editTextAnioMatriculacion.text.isEmpty() ){
                if(binding.spinnerGasolina.selectedItem.toString() == "Hibrido"  && binding.editTextAutonomia.text.isEmpty()){

                    Snackbar.make(binding.root, "Faltan Datos", Snackbar.LENGTH_SHORT).show()

                }else{
                    Snackbar.make(binding.root, "Faltan Datos", Snackbar.LENGTH_SHORT).show()
                }

            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("nombre", binding.editTextNombre.text.toString())
                intent.putExtra("matricula", binding.editTextMatricula.text.toString())
                intent.putExtra("anio", binding.editTextAnioMatriculacion.text.toString().toInt())
                intent.putExtra("combustible", binding.spinnerGasolina.selectedItem.toString())
                intent.putExtra("autonomia", binding.editTextAutonomia.text.toString().toInt())
                startActivity(intent)

            }
        }
    }
}