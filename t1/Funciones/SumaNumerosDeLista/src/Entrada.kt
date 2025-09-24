/*Crea una función que tome una lista de números enteros y
que retorne la suma de todos los números en la lista.*/

fun main() {
    val numeros = listOf<Int>(2,3,4,5)
    val resultado = devuelveDoble(numeros)
    println(resultado)
}

fun devuelveDoble(numeros: List<Int>) : Int {
    var temporal = 0

    for (i in 0 until numeros.size) {

        temporal += numeros[i]
    }

    return temporal
}