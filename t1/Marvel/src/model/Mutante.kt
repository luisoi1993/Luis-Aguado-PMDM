package model

class Mutante(nombre: String,nivel: Double, var peso: Double,var armaBiologica: ArmaBiologica) : Superheroe(nombre,nivel) {

    override fun toString(): String {
        return "Mutante(peso=$peso, armaBiologica=$armaBiologica) ${super.toString()}"
    }
}