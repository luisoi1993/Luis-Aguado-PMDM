package com.example.vuelos.model

import java.io.Serializable

class Vuelo (val origen: String, val destino: String, val fecha: String, val hora: String, val precio: Double, val asientos: Int):
    Serializable