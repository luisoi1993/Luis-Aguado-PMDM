package com.example.examendgt.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examendgt.R
import com.example.examendgt.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initGUI()

    }


    private fun initGUI() {
        val nombre = intent.getStringExtra("nombre")
        val matricula = intent.getStringExtra("matricula")
        val anio = intent.getIntExtra("anio",-1)
        val combustible = intent.getStringExtra("combustible")
        val autonomia = intent.getIntExtra("autonomia",-1)
       binding.editTextNombre.text = nombre.toString()
       binding.editTextMatricula.text = matricula.toString()
       binding.editTextAnioMatriculacion.text = anio.toString()
       binding.editTextTipoGasolina.text = combustible.toString()
       binding.editTextAutonomia.text = autonomia.toString()




        if (combustible == "Electrico"){
            binding.imageViewEtiqueta.setImageResource(R.drawable.etiqueta0)
        }else if (combustible == "Hibrido" && autonomia.toInt() > 80){
            binding.imageViewEtiqueta.setImageResource(R.drawable.etiqueta0)

        }else if(combustible == "Hibrido" && autonomia.toInt() <= 80){
            binding.imageViewEtiqueta.setImageResource(R.drawable.etiquetaeco)
        }else if (combustible == "Diesel" && anio.toInt() in 2006..2015){
            binding.imageViewEtiqueta.setImageResource(R.drawable.etiquetac)
        }else if (combustible == "Gasolina" && anio.toInt() in 2008..2017){
            binding.imageViewEtiqueta.setImageResource(R.drawable.etiquetac)
        }else{
            binding.imageViewEtiqueta.setImageResource(R.drawable.etiquetab)
        }


    }



}