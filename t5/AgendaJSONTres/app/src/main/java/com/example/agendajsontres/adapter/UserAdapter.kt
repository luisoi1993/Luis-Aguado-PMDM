package com.example.agendajsontres.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajsontres.MainActivity
import com.example.agendajsontres.R
import com.example.agendajsontres.databinding.ItemUserCardBinding
import com.example.agendajsontres.dataset.DataSet
import com.example.agendajsontres.model.User
import com.google.android.material.snackbar.Snackbar

class UserAdapter(private val context: Context) :
    RecyclerView.Adapter<UserAdapter.MyHolder>() {

    private val lista: ArrayList<User> = ArrayList()
    private val listener: OnItemUserListener = context as OnItemUserListener


    inner class MyHolder(val binding: ItemUserCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.toolbarCard.inflateMenu(R.menu.user_menu)

            binding.toolbarCard.setOnMenuItemClickListener { item ->
                val pos = bindingAdapterPosition
                if (pos == RecyclerView.NO_POSITION) return@setOnMenuItemClickListener true

                val user = lista[pos]

                when (item.itemId) {
                    R.id.menu_user_detalle -> {
                        listener.onUserDetailSelected(user)
                        true
                    }

                    R.id.menu_user_fav -> {
                        val anadido = DataSet.addFavorito(user)
                        if (!anadido) {
                            Snackbar.make(
                                binding.root,
                                "Ya está en favoritos",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                        true
                    }

                    else -> false
                }
            }
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
        Glide.with(context)
            .load(user.image)
            .into(holder.binding.imagenCard)
    }

    override fun getItemCount(): Int = lista.size


    fun clearUsers() {
        lista.clear()
        notifyDataSetChanged()
    }

    fun addUser(user: User) {
        lista.add(user)
        notifyItemInserted(lista.size - 1)
    }


    interface OnItemUserListener {
        fun onUserDetailSelected(user: User)
    }
}
