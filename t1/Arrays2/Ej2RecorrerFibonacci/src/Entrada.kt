/*Crea un array de enteros con la serie de Fibonacci de los primeros 20 números.
 A continuación, recorre el array y escribe cada número en la consola.*/

fun main() {
    val numeros = intArrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
    55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181)

    numeros.forEach {n ->
        println(n)
    }
}