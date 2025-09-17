fun esPrimo(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if(n % i == 0) {
            return false
        }
    }
    return true
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero y que indique si es primo o no.
    Ejemplo:
    // Entrada
    Introduce un número: 13

    // Salida
    El número 13 es primo
    */
    println("Introduce un número: ")
    val numero = readln().toInt()

    if(esPrimo(numero)) {
        println("El número $numero es primo")
    } else {
        println("El número $numero no es primo")
    }

}