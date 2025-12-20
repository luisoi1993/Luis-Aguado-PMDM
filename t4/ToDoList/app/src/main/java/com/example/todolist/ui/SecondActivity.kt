package com.example.todolist.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolist.R
import com.example.todolist.databinding.ActivitySecondBinding
import com.example.todolist.model.Tarea

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
        initGUI()

    }

    private fun initGUI() {
        val tarea = intent.getSerializableExtra("tarea") as Tarea
        binding.textViewTitulo.text = tarea.titulo
        binding.textViewDescripcion.text = tarea.descripcion
        binding.textViewFecha.text = tarea.fecha
        binding.textViewPrioridad.text = tarea.prioridad
        binding.textViewEstado.text = tarea.estado
        binding.imageView.setImageResource(tarea.imagen)
    }

    private fun acciones() {
        binding.buttonVolver.setOnClickListener {
            finish()
        }

    }
}