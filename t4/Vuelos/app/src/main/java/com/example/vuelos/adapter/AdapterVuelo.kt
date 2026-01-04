package com.example.vuelos.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vuelos.databinding.ItemVueloBinding
import com.example.vuelos.dataset.Dataset
import com.example.vuelos.model.Favoritos
import com.example.vuelos.model.Vuelo
import com.example.vuelos.ui.activities.DetalleActivity

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
        holder.binding.textCiudadDestino.text = vuelo.destino
         Glide.with(contexto)
            .load(Dataset.asignarImagenesCiudades(vuelo.origen)).into(holder.binding.imageViewVueloOrigen)

        Glide.with(contexto)
            .load(Dataset.asignarImagenesCiudades(vuelo.destino)).into(holder.binding.imageViewVueloDestino)

        holder.binding.btnFavorito.setOnClickListener {
            Dataset.agregarFavorito(Favoritos(vuelo.origen, vuelo.destino,vuelo.fecha,vuelo.hora
            ,vuelo.precio,vuelo.asientos))
        }

        holder.binding.btnDetalle.setOnClickListener {
            val intent = Intent(contexto, DetalleActivity::class.java)
            intent.putExtra("vuelo", vuelo)
            contexto.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return listaVuelos.size

    }






}