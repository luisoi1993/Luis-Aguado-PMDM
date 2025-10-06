/*Crea una función que tome una lista de números enteros
 y retorne el número máximo de la lista.*/

fun main() {
    val numeros = listOf<Int>(3,7,9,5)
    println("El número máximo es: ${numeroMaximo(numeros)}")
}

fun numeroMaximo(lista: List<Int>): Int?{
    return lista.maxOrNull()
}