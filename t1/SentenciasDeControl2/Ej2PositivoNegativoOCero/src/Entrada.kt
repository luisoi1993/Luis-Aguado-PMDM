/*Escribe un programa que lea un número entero y que indique si es positivo, negativo o cero.*/

fun main() {
    println("Digite un número: ")
    val numero : Int = readln().toInt();

    when{
        numero > 0 -> println("El numero $numero es mayor que cero:")
        numero < 0 -> println("El numero $numero es menor que cero:")
        else -> println("El numero $numero es cero")
    }
}