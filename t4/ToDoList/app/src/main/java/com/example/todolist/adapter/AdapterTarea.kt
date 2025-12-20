package com.example.todolist.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTareaBinding
import com.example.todolist.model.Tarea
import com.example.todolist.ui.SecondActivity
import com.google.android.material.snackbar.Snackbar

class AdapterTarea(
    private val listaTareas: ArrayList<Tarea>,
    private val contexto: Context
) : RecyclerView.Adapter<AdapterTarea.MyHolder>() {

    inner class MyHolder(val binding: ItemTareaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemTareaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val tarea = listaTareas[position]

        holder.binding.imagenFila.setImageResource(tarea.imagen)
        holder.binding.textViewTitulo.text = tarea.titulo
        holder.binding.textViewFecha.text = tarea.fecha

        holder.binding.root.setOnClickListener {
            val intent = Intent(contexto, SecondActivity::class.java)
            intent.putExtra("tarea", tarea)
            contexto.startActivity(intent)
        }
        //si se deja presionado mucho tieempo la tarea pasa a estado completado
        holder.binding.root.setOnLongClickListener{
            Snackbar.make(
                holder.binding.root,
                "Tarea completada",
                Snackbar.LENGTH_SHORT).show()
            tarea.estado = "hecho"
            true

        }
    }

    override fun getItemCount(): Int = listaTareas.size

    // 🔥 MÉTODO CLAVE PARA LOS FILTROS
    fun actualizarLista(nuevaLista: ArrayList<Tarea>) {
        listaTareas.clear()
        listaTareas.addAll(nuevaLista)
        notifyDataSetChanged()
    }
}
