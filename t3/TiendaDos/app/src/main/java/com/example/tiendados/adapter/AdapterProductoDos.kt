package com.example.tiendados.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tiendados.dataset.DataSet
import com.example.tiendados.R
import com.example.tiendados.databinding.ItemProductodosBinding
import com.example.tiendados.model.Producto

class AdapterProductoDos(
    var lista: ArrayList<Producto>,
    val listener: OnProductoCarritoListener
) : RecyclerView.Adapter<AdapterProductoDos.MyHolder>() {

    // ViewHolder usando ItemProductodosBinding
    inner class MyHolder(val binding: ItemProductodosBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemProductodosBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto = lista[position]

        Glide.with(holder.itemView.context)
            .load(producto.imagen)
            .placeholder(R.drawable.producto)
            .into(holder.binding.imagenFila)

        holder.binding.nombreFila.text = producto.nombre

        holder.binding.btnEliminar.setOnClickListener {

            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {

                val producto = lista[pos]

                DataSet.total -= producto.precio

                lista.removeAt(pos)

                notifyItemRemoved(pos)
                notifyItemRangeChanged(pos, lista.size - pos)

                listener.actualizarContadorCarrito()
            }
        }




    }

    override fun getItemCount() = lista.size

    interface OnProductoCarritoListener {
        fun actualizarContadorCarrito()
    }

    fun limpiarLista() {
        lista.clear()
        notifyDataSetChanged()
    }
}
