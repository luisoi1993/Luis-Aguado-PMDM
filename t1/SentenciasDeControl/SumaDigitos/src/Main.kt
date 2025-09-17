//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero y que calcule la suma de los dígitos de ese número.
    Ejemplo:
    // Entrada
    Introduce un número: 153

    // Salida
    La suma de los dígitos de 153 es: 9*/

    println("Introduce un número: ")
    val numero = readln().toInt()

    println("La suma de los dígitos de $numero es: ${sumaDigitos(numero)}")

}

fun sumaDigitos(num:Int) : Int {
    var n = num
    var suma = 0

    while (n > 0) {
        suma += n % 10 // Obtengo el último digito
        n /= 10
        
    }

    return suma

}