// File: ui/fragments/LaunchAdapter.kt

package com.example.examenfinal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examenfinal.databinding.ItemLaunchBinding
import com.example.examenfinal.dataset.DataSet
import com.example.examenfinal.model.Launch

class LaunchAdapter(var context: Context) : RecyclerView.Adapter<LaunchAdapter.MyHolder>() {

    private val lista = ArrayList<Launch>()

    inner class MyHolder(var binding: ItemLaunchBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemLaunchBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val launch = lista[position]

        holder.binding.textNombre.text = launch.name
        holder.binding.textDetalle.text = launch.details

        Glide.with(context).load(launch.links?.patch?.small).into(holder.binding.imagen)

        holder.binding.btnFav.setOnClickListener {
            DataSet.addFavorito(launch)
        }
    }

    override fun getItemCount(): Int = lista.size

    fun addLaunch(l: Launch) {
        lista.add(l)
        notifyItemInserted(lista.size - 1)
    }

    fun clear() {
        lista.clear()
        notifyDataSetChanged()
    }
}
