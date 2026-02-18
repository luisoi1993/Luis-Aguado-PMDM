

package com.example.examenfinal.dataset

import com.example.examenfinal.model.Launch

class DataSet {
    companion object {
        val favoritos: ArrayList<Launch> = ArrayList()

        var usuarioLogeado = false

        fun addFavorito(launch: Launch) {
            if (favoritos.find { it.id == launch.id } == null) {
                favoritos.add(launch)
            }
        }

        fun clear() {
            favoritos.clear()
        }
    }
}
