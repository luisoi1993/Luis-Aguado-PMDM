/*Crea un array de enteros con los números del 1 al 10. A continuación,
utiliza el método filter para obtener sólo los números impares. Escribe
los números impares en la consola.*/

fun main() {
    val numeros = intArrayOf(1,2,3,4,5,6,7,8,9,10)

    val numerosImpares = numeros.filter { it % 2 != 0 }

    println(numerosImpares)

}