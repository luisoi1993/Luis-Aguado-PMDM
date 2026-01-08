package com.example.compras.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compras.databinding.ItemProductoBinding
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

    }

    override fun getItemCount(): Int {
        return lista.size

    }







}