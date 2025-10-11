package model

class ArmaBiologica(nombre: String,nivelPotencia: Double,nivelDanio: Double, val descripcion : String) : Arma(nombre,nivelPotencia,nivelDanio) {

    override fun toString(): String {
        return "ArmaBiologica(descripcion='$descripcion') ${super.toString()}"
    }
}