/*Crea un array de enteros con los números del
1 al 10. A continuación, utiliza el método reduce
para obtener la suma de todos los números. Escribe
el resultado en la consola.*/

fun main() {
    val numeros = intArrayOf(1,2,3,4,5,6,7,8,9,10)

    val numerosSuma = numeros.reduce { suma, n -> suma + n }

    println("La suma de todos los numeros es : $numerosSuma")
}