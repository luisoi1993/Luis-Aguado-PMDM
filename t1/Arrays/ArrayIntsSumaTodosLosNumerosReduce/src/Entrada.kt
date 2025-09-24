/*Crea un array de enteros con los números del 1 al 10. A continuación,
 utiliza el método reduce para obtener la suma de todos los números.
 Escribe el resultado en la consola.*/

fun main() {
    val numeros = arrayOf(1,2,3,4,5,6,7,8,9,10)
    val sumaNumeros = numeros.reduce { acumulador , elemento -> acumulador + elemento }
    println(sumaNumeros)

}