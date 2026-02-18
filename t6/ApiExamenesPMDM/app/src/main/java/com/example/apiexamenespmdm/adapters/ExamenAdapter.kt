package com.example.apiexamenespmdm.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexamenespmdm.R
import com.example.apiexamenespmdm.databinding.ItemExamenBinding
import com.example.apiexamenespmdm.model.Examen
import com.google.android.material.snackbar.Snackbar

class ExamenAdapter(val lista: List<Examen>, val context: Context): RecyclerView.Adapter<ExamenAdapter.ExamenViewHolder>() {



    inner class ExamenViewHolder(val binding: ItemExamenBinding): RecyclerView.ViewHolder(binding.root){
        init {
            //cargar el toolbar
            binding.toolbar.inflateMenu(R.menu.menu_examen)
            //dependiendo a cual sea el examen muestra lo del propio examen
            binding.toolbar.setOnMenuItemClickListener{
                when(it.itemId){
                    R.id.menu_detalle -> {
                        var bundle = Bundle()
                        bundle.putSerializable("examen", lista[adapterPosition])
                        //cambiar de fragment
                        Navigation
                            .findNavController(binding.root) // 🔥 ESTA ES LA CLAVE
                            .navigate(R.id.action_fragmentListado_to_fragmentDetalle, bundle)
                        true
                    }
                    R.id.menu_dificultad -> {
                        Snackbar.make(binding.root, "Dificultad: ${lista[adapterPosition].dificultad}", Snackbar.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExamenViewHolder {
        val binding = ItemExamenBinding.inflate(LayoutInflater.from(context), parent, false)
        return ExamenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExamenAdapter.ExamenViewHolder, position: Int) {
        val posicion = lista[position]
        holder.binding.textViewTitulo.text = posicion.titulo
        holder.binding.textViewTema.text = posicion.tema
    }

    override fun getItemCount(): Int {
        return lista.size

    }

}