package com.example.tienda.dataset

import com.example.tienda.model.Usuario

class DataSet {
    companion object {

        val listaUsuarios: ArrayList<Usuario> = ArrayList()

        var usuarioLogeado: Usuario? = null   // ⭐ NUEVO

        fun addUsuario(user: Usuario): Boolean {
            if (listaUsuarios.find { it.correo == user.correo } != null) {
                return false
            } else {
                listaUsuarios.add(user)
                return true
            }
        }

        fun loginUser(correo: String, contrasenia: String): Boolean {

            val usuario = listaUsuarios
                .find { it.correo == correo && it.contrasenia == contrasenia }

            usuarioLogeado = usuario

            return usuario != null
        }
    }
}
