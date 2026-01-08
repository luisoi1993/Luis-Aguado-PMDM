package com.example.compras.model

import java.io.Serializable

class Producto(val imagen: String, val nombre: String,val precio: Double,
               val categoria: String,val stock: Int, val descripcion: String ) : Serializable