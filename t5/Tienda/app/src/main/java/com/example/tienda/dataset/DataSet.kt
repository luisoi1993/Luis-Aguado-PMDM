package com.example.tienda.dataset

import com.example.tienda.model.Usuario

class DataSet {
    companion object {
        val listaUsuarios: ArrayList<Usuario> = ArrayList()

        fun addUsuario(usuario: Usuario) : Boolean {
            if(listaUsuarios.filter{it.correo == usuario.correo}!=null){
                this.listaUsuarios.add(usuario)
                return false
            }else{
                this.listaUsuarios.add(usuario)
            }
            return true
            }

        fun loginUser(correo: String, contrasenia: String): Boolean{
            return listaUsuarios
                .find{it.correo == correo && it.contrasenia == contrasenia}!=null);
        }




    }
}