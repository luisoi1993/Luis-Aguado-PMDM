/*Crea una función que tome una lista de números enteros y que retorne una
 lista que contenga el cuadrado de cada número en la lista.*/

fun main() {
    val numeros = mutableListOf<Int>(3,5,7,89,8)
    val numerosCuadrado = listaCuadrados(numeros)

    println("La lista de cuadrados es:  $numerosCuadrado" )
}

fun listaCuadrados(lista : List<Int>): List<Int>{
    var lista2 = mutableListOf<Int>()
    lista.forEach { n ->  lista2.add(n*n)  }

    return lista2
}
