package model

abstract class Arma(var nombre: String, val nivelPotencia: Double,val nivelDanio : Double) {
    val id : Int

    companion object{
        private var contador = 0
    }
    init {
        contador++
        id = contador
    }

    override fun toString(): String {
        return "Arma(nombre='$nombre', nivelDanio=$nivelDanio, id=$id)"
    }


}