//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
  /*Escribe un programa que lea un número entero y que muestre por pantalla su
  representación en hexadecimal.
    Ejemplo:
    // Entrada
    Introduce un número: 255

    // Salida
    La representación hexadecimal de 255 es: FF*/

    println("Introduce un número: ")
    val numero = readln().toInt()

    val hexadecimal = numero.toString(16)

    println("La representación hexadecimal de $numero es: $hexadecimal")
}