package com.example.agendajsontres.dataset

import com.example.agendajsontres.model.User
import com.google.android.material.snackbar.Snackbar

class DataSet {
    companion object{
        val favoritos: ArrayList<User> = ArrayList()

        fun addFavorito(user: User): Boolean {
            return if (!favoritos.contains(user)) {
                favoritos.add(user)
                true
            } else {
                false
            }
        }




        fun removeFavorito(user: User){
            favoritos.remove(user)
        }


    }
}