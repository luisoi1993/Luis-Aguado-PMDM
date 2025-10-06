/*Crea una función que tome una lista de números enteros y que retorne la suma de todos los números en la lista.*/

fun main() {
    val numeros = mutableListOf<Int>(1,3,5,6)
    val sumaTotal = sumaLista(numeros)

    println("La suma total de la lista de suma es: $sumaTotal")
}

fun sumaLista(lista: List<Int>): Int{
    var sumaTotal : Int = 0
    lista.forEach { n ->
        sumaTotal += n
    }

    return sumaTotal
}