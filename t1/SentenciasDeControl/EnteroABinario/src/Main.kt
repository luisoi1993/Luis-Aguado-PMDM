//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero y que muestre por pantalla su representación en binario.
    Ejemplo:
    // Entrada
    Introduce un número: 25

    // Salida
    La representación binaria de 25 es: 11001*/

    println("Introduce un número: ")
    val numero = readln().toInt()

    val binario = numero.toString(2)

    println("La representación binaria de $numero es: $binario")
}