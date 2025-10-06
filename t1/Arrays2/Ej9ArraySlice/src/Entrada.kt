/*Crea un array de enteros con los números del 1 al 10. A continuación, utiliza el método
slice para obtener los elementos de la posición 2 a la posición 6. Escribe los números resultantes en la consola.*/

fun main() {
    val numeros = intArrayOf(1,2,3,4,5,6,7,8,9,10)

    val slice = numeros.slice( 2..6)

    println("El array números recortado de la posición 2 a la 6 es: $slice")
}