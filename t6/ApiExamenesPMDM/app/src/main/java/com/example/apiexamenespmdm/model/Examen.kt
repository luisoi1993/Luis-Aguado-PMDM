package com.example.apiexamenespmdm.model

import java.io.Serializable

data class Examen(
    val titulo: String = "",
    val tema: String = "",
    val detalle: String = "",
    val dificultad: String = "",
    val id: String = ""
)
 : Serializable
