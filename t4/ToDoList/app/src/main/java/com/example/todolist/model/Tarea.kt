package com.example.todolist.model

import java.io.Serializable

class Tarea (
    var imagen: Int,
    var titulo: String,
    var descripcion: String,
    var fecha: String,
    var prioridad: String,
    var estado: String
) : Serializable