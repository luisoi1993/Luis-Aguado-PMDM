package model

class Circulo(var radio: Double) : Figura() {

    override fun calcularArea(): Double {
        val area = 3.14 * (radio * radio)
        return area
    }

    override fun mostrarDatos() {
        println("El radio del circulo es: $radio")
        println("El area del circulo es: ${calcularArea()}")
    }
}