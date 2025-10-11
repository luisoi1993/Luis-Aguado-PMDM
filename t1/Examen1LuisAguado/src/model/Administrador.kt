package model

class Administrador(var nombre: String,var clave: Int) {
    val id : Int

    companion object{
        private var contador = 0
    }

    init {
        contador++
        id = contador
    }
}