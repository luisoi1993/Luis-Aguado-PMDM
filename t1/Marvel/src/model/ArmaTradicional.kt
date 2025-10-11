package model

class ArmaTradicional(nombre: String,nivelPotencia: Double,nivelDanio: Double, val peso: Double) : Arma(nombre,nivelPotencia,nivelDanio) {

    override fun toString(): String {
        return "ArmaTradicional(peso=$peso) ${super.toString()}"
    }
}