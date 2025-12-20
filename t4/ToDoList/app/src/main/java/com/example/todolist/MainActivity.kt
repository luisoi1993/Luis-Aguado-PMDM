package com.example.todolist

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.AdapterTarea
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.dataset.DataSet
import com.example.todolist.model.Tarea
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterTarea: AdapterTarea
    private var lista: ArrayList<Tarea> = arrayListOf()

    private var filtroPrioridad = "Todas"
    private var filtroEstado = "Todas"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        acciones()
    }

    private fun instancias() {
        lista = DataSet.getListaFiltrada("Todas", "Todas")

        adapterTarea = AdapterTarea(lista, this)

        if (resources.configuration.orientation == 1) {
            binding.recyclerViewTareas.layoutManager =
                LinearLayoutManager(this)
        } else {
            binding.recyclerViewTareas.layoutManager =
                GridLayoutManager(this, 2)
        }

        binding.recyclerViewTareas.adapter = adapterTarea
    }

    private fun acciones() {

        binding.buttonRellenarDatos.setOnClickListener(this)

        // ---------- SPINNER ESTADO ----------
        binding.spinnerEstado.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    filtroEstado = binding.spinnerEstado.selectedItem.toString()

                    when (filtroEstado) {
                        "Todas" -> binding.imageViewSpinnerEstado.setImageResource(R.drawable.todoadd)
                        "por hacer" -> binding.imageViewSpinnerEstado.setImageResource(R.drawable.highpriority)
                        "haciendo" -> binding.imageViewSpinnerEstado.setImageResource(R.drawable.progress)
                        "hecho" -> binding.imageViewSpinnerEstado.setImageResource(R.drawable.hacer)
                    }

                    refrescarLista()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        // ---------- SPINNER PRIORIDAD ----------
        binding.spinnerPrioridad.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    filtroPrioridad = binding.spinnerPrioridad.selectedItem.toString()

                    when (filtroPrioridad) {
                        "Todas" -> binding.imageViewSpinnerPrioridad.setImageResource(R.drawable.todoadd)
                        "Baja" -> binding.imageViewSpinnerPrioridad.setImageResource(R.drawable.lowpriority)
                        "Media" -> binding.imageViewSpinnerPrioridad.setImageResource(R.drawable.mediumpriority)
                        "Prioritaria" -> binding.imageViewSpinnerPrioridad.setImageResource(R.drawable.highpriority)
                    }

                    refrescarLista()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }

    private fun refrescarLista() {
        val nuevaLista =
            DataSet.getListaFiltrada(filtroPrioridad, filtroEstado)

        adapterTarea.actualizarLista(nuevaLista)
    }

    override fun onClick(v: View?) {
        if (v == binding.buttonRellenarDatos) {

            val titulo = binding.textViewTitulo.text.toString()

            if (titulo.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "El título no puede estar vacío",
                    Snackbar.LENGTH_SHORT
                ).show()
                return
            }

            val fecha = SimpleDateFormat(
                "dd/MM/yyyy",
                Locale.getDefault()
            ).format(Date())

            val tarea = Tarea(
                imagen = R.drawable.friendkind,
                titulo = titulo,
                descripcion = "Nueva tarea",
                fecha = fecha,
                prioridad = filtroPrioridad,
                estado = "por hacer"
            )

            DataSet.listaTareas.add(tarea)
            refrescarLista()
            binding.textViewTitulo.setText("")
        }
    }
}
