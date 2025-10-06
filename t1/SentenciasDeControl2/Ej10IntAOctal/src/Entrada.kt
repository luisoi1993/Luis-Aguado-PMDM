/*Escribe un programa que lea un número entero y que muestre por pantalla su representación en octal.*/

fun main() {
    println("Digite un número: ")
    val numero: Int = readln().toInt()
    val octal = numero.toString(8)

    println("EL numero $numero en octal es $octal")
}