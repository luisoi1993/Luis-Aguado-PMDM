//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número
    entero y que muestre por pantalla su representación en octal.
    Ejemplo:
    // Entrada
    Introduce un número: 64

    // Salida
    La representación octal de 64 es: 100*/

    println("Introduce un número: ")
    val numero = readln().toInt()

    val octal = numero.toString(8)

    println("La representación octal de $numero es: $octal")
}