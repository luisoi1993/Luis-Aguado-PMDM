//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero N y que compruebe si
     es un número palíndromo (se lee igual de izquierda a derecha que de derecha
      a izquierda).
    Ejemplo:
    // Entrada
    Introduce un número: 12321

    // Salida
    El número 12321 es palíndromo*/
    println("Introduce un número: ")
    val numero = readln()

    val reverso = numero.reversed()

    println(reverso)
}