package com.example.agendajsontres.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajsontres.R
import com.example.agendajsontres.databinding.FavUserCardBinding
import com.example.agendajsontres.model.User
import com.example.agendajsontres.ui.activities.FavoritoActivity

class FavoritoAdapter(
    private val context: Context,
    private val lista: ArrayList<User>
) : RecyclerView.Adapter<FavoritoAdapter.MyHolder>() {

    private lateinit var listener: OnFavDetailSelected

    inner class MyHolder(val binding: FavUserCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.toolbarCard.inflateMenu(R.menu.fav_menu)

            binding.toolbarCard.setOnMenuItemClickListener {
                val pos = bindingAdapterPosition
                if (pos == RecyclerView.NO_POSITION) return@setOnMenuItemClickListener true

                when (it.itemId) {

                    R.id.menu_quitar -> {
                        lista.removeAt(pos)
                        notifyItemRemoved(pos)
                    }

                    R.id.menu_user_detalle -> {
                        listener.onFavDetailSelected(lista[pos])
                    }
                }
                true
            }
        }
    }

    init {
        listener = context as FavoritoActivity
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = FavUserCardBinding.inflate(
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
    }

    override fun getItemCount(): Int = lista.size

    interface OnFavDetailSelected {
        fun onFavDetailSelected(user: User)
    }
}
