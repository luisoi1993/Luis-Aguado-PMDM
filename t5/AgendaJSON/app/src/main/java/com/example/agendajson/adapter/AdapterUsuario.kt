package com.example.agendajson.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajson.MainActivity
import com.example.agendajson.databinding.ItemUsuarioBinding
import com.example.agendajson.model.User
import com.example.agendajson.ui.dialogs.DialogoFiltrar

class AdapterUsuario(var lista: ArrayList<User>, var contexto: Context) :
RecyclerView.Adapter<AdapterUsuario.MyHolder>(){
    inner class MyHolder(var binding: ItemUsuarioBinding): RecyclerView.ViewHolder(binding.root){

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        var binding : ItemUsuarioBinding =
            ItemUsuarioBinding.inflate(android.view.LayoutInflater.from(contexto),parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val usuario = lista[position]
        holder.binding.toolbarCard.title = usuario.firstName
        holder.binding.nombreFila.text = usuario.firstName
        holder.binding.correoFila.text = usuario.email

        Glide.with(contexto)
            .load(usuario.image).into(holder.binding.imagenFila)

        //si se pulsa cualquier parte de la card
        holder.binding.root.setOnClickListener{
            val dialogoDetalle = DialogoFiltrar()
            dialogoDetalle.show((contexto as MainActivity).supportFragmentManager,"DialogoDetalle")
        }

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setDatos(nuevaLista: List<User>) {
        lista.clear()
        lista.addAll(nuevaLista)
        notifyDataSetChanged()
    }

}
