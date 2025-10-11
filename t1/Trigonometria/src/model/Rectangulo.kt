package model

class Rectangulo(var base: Double,var altura: Double) : Figura() {

    override fun calcularArea(): Double{
        val area = base * altura
        return area
    }

    fun calcularPerimetro(): Double{
        val perimetro = 2 *(base + altura)
        return perimetro
    }

    override fun mostrarDatos() {
        println("La base del rectangulo es: $base")
        println("La altura del rectangulo es: $altura")
        println("El area del rectangulo es: ${calcularArea()}")
        println("El perimetro del rectangulo es: ${calcularPerimetro()}")
    }
}