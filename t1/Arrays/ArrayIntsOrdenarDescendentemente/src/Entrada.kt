/*Crea un array de enteros con los números del 1 al 5. A continuación,
 utiliza el método sortedDescending para ordenar los números de forma descendente.
 Escribe los números resultantes en la consola.*/

fun main() {
    val numeros = arrayOf(1,2,3,4,5)
    val numerosDescendientes = numeros.sortedDescending()
    println(numerosDescendientes)
}