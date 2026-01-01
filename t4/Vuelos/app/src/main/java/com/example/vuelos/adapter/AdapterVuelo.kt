package com.example.vuelos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vuelos.databinding.ItemVueloBinding
import com.example.vuelos.model.Vuelo

class AdapterVuelo(var listaVuelos: ArrayList<Vuelo>, var contexto: Context) :
    RecyclerView.Adapter<AdapterVuelo.MyHolder>() {

        inner class MyHolder(var binding: ItemVueloBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        var binding = ItemVueloBinding.inflate(LayoutInflater.from(contexto), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val vuelo = listaVuelos[position]
        holder.binding.textCiudadOrigen.text = vuelo.origen
    }

    override fun getItemCount(): Int {
        return listaVuelos.size

    }


}