package model

class Triangulo(var base: Double,var altura: Double): Figura() {

    override fun calcularArea(): Double {
        val area = (base * altura) / 2
        return area
    }

    override fun mostrarDatos() {
        println("La base del triangulo es: $base")
        println("La altura del triangulo es: $altura")
        println("El area del triangulo es: ${calcularArea()}")
    }
}