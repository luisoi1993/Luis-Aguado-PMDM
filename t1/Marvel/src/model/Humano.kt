package model

class Humano(nombre: String,nivel: Double, var peso: Double,var armaTradicional: ArmaTradicional) : Superheroe(nombre,nivel) {

    override fun toString(): String {
        return "Humano(peso=$peso, armaTradicional=$armaTradicional) ${super.toString()}"
    }
}