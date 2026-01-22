package com.example.agendajsondos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajsondos.R
import com.example.agendajsondos.databinding.ItemUserCardBinding
import com.example.agendajsondos.model.User

class UserAdapter(
    private val context: Context,
    private val listener: OnUserClickListener
) : RecyclerView.Adapter<UserAdapter.MyHolder>() {

    private val lista = ArrayList<User>()

    inner class MyHolder(val binding: ItemUserCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.toolbarCard.inflateMenu(R.menu.user_menu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemUserCardBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val user = lista[position]

        holder.binding.textoCard.text = user.email
        holder.binding.toolbarCard.title = user.firstName
        Glide.with(context).load(user.image).into(holder.binding.imagenCard)

        holder.binding.root.setOnClickListener {
            listener.onUserClick(user)
        }

        holder.binding.toolbarCard.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_user_detalle -> {
                    listener.onUserClick(user)
                    true
                }
                R.id.menu_user_favorito -> {
                    true
                }
                else -> false
            }
        }
    }

    override fun getItemCount(): Int = lista.size

    fun clearUsers() {
        lista.clear()
        notifyDataSetChanged()
    }

    fun addUSer(user: User) {
        lista.add(user)
        notifyItemInserted(lista.size - 1)
    }

    interface OnUserClickListener {
        fun onUserClick(user: User)
    }
}
