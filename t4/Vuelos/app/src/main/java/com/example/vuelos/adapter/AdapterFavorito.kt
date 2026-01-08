package com.example.vuelos.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vuelos.databinding.ItemFavoritoBinding
import com.example.vuelos.dataset.Dataset
import com.example.vuelos.model.Favoritos

class AdapterFavorito(var listaFavoritos: ArrayList<Favoritos>, var contexto: Context) :
    RecyclerView.Adapter<AdapterFavorito.MyHolder>() {
        inner class MyHolder(var binding: ItemFavoritoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterFavorito.MyHolder {
        var binding = ItemFavoritoBinding.inflate(LayoutInflater.from(contexto), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterFavorito.MyHolder, position: Int) {
        val favorito = listaFavoritos[position]
        Log.d("ADAPTER", "Origen=${favorito.origen}, Destino=${favorito.destino}")

        holder.binding.textCiudadOrigen.text = favorito.origen
        holder.binding.textCiudadDestino.text = favorito.destino

        Glide.with(contexto)
            .load(Dataset.asignarImagenesCiudades(favorito.origen)).into(holder.binding.imageViewVueloOrigen)

        Glide.with(contexto)
            .load(Dataset.asignarImagenesCiudades(favorito.destino)).into(holder.binding.imageViewVueloDestino)
    }

    override fun getItemCount(): Int {
        return listaFavoritos.size
    }


}


