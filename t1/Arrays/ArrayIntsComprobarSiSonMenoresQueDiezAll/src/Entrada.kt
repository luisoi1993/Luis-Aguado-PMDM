/*Crea un array de enteros con los números del 1 al 5. A continuación, utiliza el
método all para comprobar si todos los números son menores que 10. Escribe el
 resultado en la consola.*/

fun main() {
    val enteros = arrayOf(1,2,3,4,5)
    val enterosMenor10 = enteros.all { it < 10 }
    println(enterosMenor10)
}