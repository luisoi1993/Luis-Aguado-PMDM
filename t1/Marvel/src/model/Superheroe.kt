package model

abstract class Superheroe(var nombre: String,var nivel: Double) {
    var id : Int

    companion object{
        private var contador = 0
    }

    init {
        contador++
        id = contador
    }

    override fun toString(): String {
        return "Superheroe(nombre='$nombre', nivel=$nivel, id=$id)"
    }


}