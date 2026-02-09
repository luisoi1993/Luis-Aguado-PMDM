package com.example.tiendados.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tiendados.MainActivity
import com.example.tiendados.R
import com.example.tiendados.databinding.ItemUserCardBinding
import com.example.tiendados.model.User
import com.example.tiendados.ui.dialog.DialogDetalle

class UserAdapter(
    private val users: ArrayList<User>,
    private val context: Context
) : RecyclerView.Adapter<UserAdapter.MyHolder>() {

    inner class MyHolder(val binding: ItemUserCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                binding.toolbar2.inflateMenu(R.menu.menu_adapter)
                binding.toolbar2.setOnMenuItemClickListener { item ->
                    val pos = bindingAdapterPosition
                    if(pos == RecyclerView.NO_POSITION) return@setOnMenuItemClickListener false
                    val user = users[pos]

                    when(item.itemId){
                        R.id.menu_detalle -> {
                            //pasarle el usuario al detalle
                            val bundle = Bundle()
                            bundle.putSerializable("user", user)
                            val dialog = DialogDetalle()
                            dialog.arguments = bundle
                            dialog.show((context as MainActivity).supportFragmentManager, "dialog")


                            true
                        }

                        else -> false
                    }

                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemUserCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val user = users[position]

        holder.binding.nombreCard.text = user.nombre
        holder.binding.correoCard.text = user.correo
    }

    override fun getItemCount(): Int = users.size
}
