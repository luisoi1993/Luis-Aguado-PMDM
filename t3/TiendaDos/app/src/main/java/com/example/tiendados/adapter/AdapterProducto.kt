package com.example.tiendados.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tiendados.dataset.DataSet
import com.example.tiendados.ui.activity.DetalleActivity
import com.example.tiendados.R
import com.example.tiendados.databinding.ItemProductoBinding
import com.example.tiendados.model.Producto

import com.google.android.material.snackbar.Snackbar

class AdapterProducto(
    var lista: ArrayList<Producto>,
    val listener: OnProductoCarritoListener
) : RecyclerView.Adapter<AdapterProducto.MyHolder>() {

    inner class MyHolder(val binding: ItemProductoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemProductoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto = lista[position]

        // Cargar imagen con Glide SIN contexto:
        Glide.with(holder.itemView.context)
            .load(producto.imagen)
            .placeholder(R.drawable.producto)
            .into(holder.binding.imagenFila)

        holder.binding.nombreFila.text = producto.nombre

        holder.binding.btnDetalle.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetalleActivity::class.java)
            intent.putExtra("producto", producto)
            holder.itemView.context.startActivity(intent)
        }

        holder.binding.btnCompra.setOnClickListener {
            DataSet.anadirProducto(producto)
            DataSet.contador++
            DataSet.total += producto.precio
            listener.actualizarContadorCarrito()
        }
    }

    override fun getItemCount() = lista.size

    interface OnProductoCarritoListener {
        fun actualizarContadorCarrito()
    }
}
