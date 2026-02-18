package com.example.finalfutbol.model

import java.io.Serializable

class User (var nombre: String = "", var apellido: String = "", var telefono: Int = 0,
           var correo: String = "", var contraseña: String = "", var direccion: String = ""): Serializable

