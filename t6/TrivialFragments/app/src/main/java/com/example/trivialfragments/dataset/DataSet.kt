package com.example.trivialfragments.dataset

import com.example.trivialfragments.model.Usuario

class DataSet {
    companion object{
        var puntuacion = 0

        var nickRecord = ""

        var record = 0
        var listaUsuarios = ArrayList<Usuario>()
        fun addUsuario(usuario: Usuario){
            listaUsuarios.add(usuario)
        }
        fun comprobarNick(nick: String): Boolean{
            for (usuario in listaUsuarios){
                if (usuario.nick == nick){
                    return true
                }
            }
            return false
        }

        fun comprobarCorreo(correo: String): Boolean{
            for (usuario in listaUsuarios){
                if (usuario.correo == correo){
                    return true
                }
            }
            return false
        }
        fun comprobarUsuario(correo: String, password: String): Boolean{
            for (usuario in listaUsuarios){
                if (usuario.correo == correo && usuario.password == password){
                    return true
                }
            }
            return false
        }
        var usuarioLogeado = Usuario("","", "",0)

        fun ponerRecord(puntuacion: Int,nick: String){
            if (puntuacion > record){
                record = puntuacion
                nickRecord = nick
            }
        }


    }
}