/*Crea una función que tome una lista de números enteros y que
 retorne una lista que contenga el cuadrado de cada número en la lista.*/

fun main() {
    val numeros = listOf<Int>(2,3,4,5)
    val resultado = devuelveCuadrado(numeros)
    println(resultado.contentToString())

}

fun devuelveCuadrado(numeros : List<Int>) : Array<Int> {
    val cuadrados = mutableListOf<Int>()

    for (i in 0 until numeros.size){
        val cuadrado = numeros[i] * numeros[i]
        cuadrados.add(cuadrado)
    }
    return cuadrados.toTypedArray()
}