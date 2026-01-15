package com.example.compras.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compras.databinding.ItemProductoBinding
import com.example.compras.dataset.DataSet
import com.example.compras.model.Producto

class AdepterProducto(var lista: ArrayList<Producto>, var contexto: Context) :
    RecyclerView.Adapter<AdepterProducto.MyHolder>()  {

    inner class MyHolder(var binding: ItemProductoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
       var binding: ItemProductoBinding =
            ItemProductoBinding.inflate(LayoutInflater.from(contexto), parent, false)
        return MyHolder(binding)


    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
       val producto = lista[position]
        holder.binding.tituloFila.text = producto.nombre
        holder.binding.categoriaFila.text = producto.categoria
        holder.binding.PrecioFila.text = producto.precio.toString()

        Glide.with(contexto).load(producto.imagen).into(holder.binding.imagenFila)

        holder.binding.btnDetalle.setOnClickListener {

        }

        holder.binding.btnCompra.setOnClickListener {
            DataSet.contador++
        }

    }

    override fun getItemCount(): Int {
        return lista.size

    }









}