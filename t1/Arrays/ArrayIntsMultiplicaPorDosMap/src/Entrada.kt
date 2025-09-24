/*Crea un array de enteros con los números del 1 al 5. A continuación, utiliza el
 método map para multiplicar cada número por 2. Escribe los números resultantes en la consola.*/

fun main() {
    val numeros = arrayOf(1,2,3,4,5)
    val numerosMultiplicados = numeros.map { it * 2 }
    println(numerosMultiplicados)
}