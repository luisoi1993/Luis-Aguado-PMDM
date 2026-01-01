package com.example.vuelos.dataset

import com.example.vuelos.model.Favoritos
import com.example.vuelos.model.Usuario
import com.example.vuelos.model.Vuelo

class Dataset {

    companion object {

        var listaUsuarios = arrayListOf<Usuario>()
        var listaVuelos = arrayListOf<Vuelo>()


        fun agregarUsuario(usuario: Usuario) {
            listaUsuarios.add(usuario)
        }

        //funcion para comprobar qu no haya ningun usuario con el mismo correo

        fun comprobarCorreo(correo: String): Boolean {
            for (usuario in listaUsuarios) {
                if (usuario.correo == correo) {
                    return false
                }
            }
            return true
        }

        //funcion para comprobar que el correo y la contraseña sean correctos

        fun comprobarLogin(correo: String, contraseña: String): Boolean {
            for (usuario in listaUsuarios) {
                if (usuario.correo == correo && usuario.contraseña == contraseña) {
                    return true
                }

            }
            return false
        }

        fun agregarVuelo(vuelo: Vuelo) {
            listaVuelos.add(vuelo)
        }


        init {
            val nombre = "luis"
            val correo = "luis@gmail.com"
            val contraseña = "123456"
            val perfil = "admin"
            val edad = 20
            val vuelos = ArrayList<Vuelo>()
            val favoritos = ArrayList<Favoritos>()

            val admin = Usuario(
                nombre,
                correo,
                contraseña,
                perfil,
                edad,
                vuelos,
                favoritos
            )

            agregarUsuario(admin)
        }
    }
}
