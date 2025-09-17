//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero y que indique si es par o impar.
    Ejemplo:
    // Entrada
    Introduce un número: 7

    // Salida
    El número 7 es impar
    */

    println("Digite un numero entero: ")
    val numero = readln().toInt()

    if(numero % 2 == 0){
        println("El número $numero es par")
    } else {
        println("El número $numero es impar")
    }
}