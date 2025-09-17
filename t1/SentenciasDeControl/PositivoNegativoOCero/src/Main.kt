//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero y que indique si es positivo, negativo o cero.
    Ejemplo:
    // Entrada
    Introduce un número: -15

    // Salida
    El número -15 es negativo*/

    println("Digite un número entero: ")
    val numero = readln().toInt()

    if(numero > 0){
        println("El número $numero es positivo")
    }
    else if (numero < 0){
        println("El número $numero es negativo")
    }
    else {
        println("El número es 0")
    }
}