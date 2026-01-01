package com.example.vuelos.model

import java.io.Serializable

class Usuario(val nombre: String, val correo: String, val contraseña: String, val perfil: String, val edad: Int, val vuelos: ArrayList<Vuelo>, val favoritos: ArrayList<Favoritos>) : Serializable

