package com.example.tiendados.model

import java.io.Serializable

data class User(
    var nombre: String = "",
    var apellido: String = "",
    var correo: String = "",
    var edad: Int = 0
) : Serializable
