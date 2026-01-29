package com.example.tienda.model

import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val correo: String,
    val contrasenia: String
)