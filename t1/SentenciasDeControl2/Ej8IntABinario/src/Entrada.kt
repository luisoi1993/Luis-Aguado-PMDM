/*Escribe un programa que lea un número entero y que muestre por pantalla su representación en binario.*/

fun main() {
    println("Digite un número: ")
    val numero : Int = readln().toInt()
    val binario = numero.toString(2)

    println("El numero $numero en binario es $binario")
}